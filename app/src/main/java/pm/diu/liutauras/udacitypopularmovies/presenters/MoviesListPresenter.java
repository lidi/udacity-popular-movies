package pm.diu.liutauras.udacitypopularmovies.presenters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import pm.diu.liutauras.udacitypopularmovies.views.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import pm.diu.liutauras.udacitypopularmovies.domain.GetMoviesUseCase;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.ui.RecyclerClickListener;
import pm.diu.liutauras.udacitypopularmovies.ui.activities.MoviesListActivity;
import pm.diu.liutauras.udacitypopularmovies.views.MoviesListView;
import rx.Subscription;

public class MoviesListPresenter implements Presenter, RecyclerClickListener {
  private final GetMoviesUseCase moviesUseCase;
  private final Context context;

  private boolean isMoviesRequestRunning;

  private Subscription moviesSubscription;

  private List<Movie> movies;
  private MoviesListView moviesListView;
  private Intent intent;

  @Inject
  public MoviesListPresenter(Context context, GetMoviesUseCase moviesUseCase) {
    this.context = context;
    this.moviesUseCase = moviesUseCase;
    movies = new ArrayList<>();
  }

  @Override public void onStart() {
    // Not used
  }

  @Override public void onStop() {
    // Not used
  }

  @Override public void onPause() {

    moviesSubscription.unsubscribe();
    isMoviesRequestRunning = false;
  }

  @Override public void attachView(View v) {
    moviesListView = (MoviesListView) v;
  }

  @Override public void attachIncomingIntent(Intent intent) {
    this.intent = intent;
  }

  @Override public void onCreate() {
    getMovies();
  }

  private void getMovies() {
    Log.v("#L#", "Getting movies");
    isMoviesRequestRunning = true;
    showLoadingUI();

    moviesSubscription = moviesUseCase.execute().subscribe(movies -> {
          Log.v("#L#", String.valueOf(movies.size()));
          this.movies.addAll(movies);
          moviesListView.bindMoviesList(this.movies);
          moviesListView.showMovieList();
          isMoviesRequestRunning = false;
        }, error -> Log.v("#L# Error loading movies", error.getMessage()));
  }

  private void showLoadingUI() {
    moviesListView.showLoadingView();
  }

  @Override public void onElementClick(int position, ImageView characterImageView) {

  }

  public void onListEndReached() {

  }
}