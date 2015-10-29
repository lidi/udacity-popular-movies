package pm.diu.liutauras.udacitypopularmovies.presenters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import pm.diu.liutauras.udacitypopularmovies.domain.GetMoviesUsecase;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.ui.RecyclerClickListener;
import pm.diu.liutauras.udacitypopularmovies.ui.activities.MovieDetailActivity;
import pm.diu.liutauras.udacitypopularmovies.views.BaseView;
import pm.diu.liutauras.udacitypopularmovies.views.MoviesListView;
import rx.Subscription;

public class MoviesListPresenter implements Presenter, RecyclerClickListener {
  private final GetMoviesUsecase moviesUseCase;
  private final Context context;

  private Subscription moviesSubscription;

  private List<Movie> movies;
  private MoviesListView moviesListView;

  @Inject
  public MoviesListPresenter(Context context, GetMoviesUsecase moviesUseCase) {
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
  }

  @Override public void attachView(BaseView v) {
    moviesListView = (MoviesListView) v;
  }

  @Override public void attachIncomingIntent(Intent intent) {
  }

  @Override public void onCreate() {
    getMovies();
  }

  private void getMovies() {
    showLoadingUI();

    moviesSubscription = moviesUseCase.execute().subscribe(movies -> {
          this.movies.addAll(movies);
          moviesListView.bindMoviesList(this.movies);
          moviesListView.showMovieList();
        }, error -> Log.v("Error loading movies", error.getMessage()));
  }

  private void showLoadingUI() {
    moviesListView.showLoadingView();
  }

  @Override public void onElementClick(int position, View clickedView) {
    Intent intent = new Intent (context, MovieDetailActivity.class);
    Movie selectedMovie = movies.get(position);
    intent.putExtras(getBundle(selectedMovie));
    context.startActivity(intent,
        moviesListView.getActivityOptions(position, clickedView).toBundle());
  }
  @NonNull
  private Bundle getBundle(Movie movie) {
    Bundle extras = new Bundle();

    extras.putParcelable("SELECTED_MOVIE_DETAILS", movie);
    return extras;
  }

  public void onListEndReached() {

  }
}
