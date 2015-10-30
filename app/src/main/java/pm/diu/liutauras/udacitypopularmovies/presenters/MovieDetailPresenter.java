package pm.diu.liutauras.udacitypopularmovies.presenters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.views.BaseView;
import pm.diu.liutauras.udacitypopularmovies.views.MovieDetailView;

public class MovieDetailPresenter implements Presenter, AdapterView.OnItemSelectedListener {

  private MovieDetailView movieDetailView;
  private Intent intent;
  private PresenterHelper helper = new PresenterHelper();

  @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    // Not implemented
  }

  @Override public void onNothingSelected(AdapterView<?> parent) {
    // Not implemented
  }

  @Override public void onStart() {
    // Not implemented
  }

  @Override public void onStop() {
    // Not implemented
  }

  @Override public void onPause() {
    // Not implemented
  }

  @Override public void attachView(BaseView v) {
    movieDetailView = (MovieDetailView) v;
  }

  @Override public void attachIncomingIntent(Intent intent) {
    this.intent = intent;
  }

  @Override public void onCreate() {
    // Not implemented
  }

  @Override public void onSortBy(String criteria) {
    // Not implemented
  }

  public void initializePresenter() {

    Bundle extras = intent.getExtras();
    Movie movie = extras.getParcelable("SELECTED_MOVIE_DETAILS");

    if (movie != null) {
      movieDetailView.showMoviePoster(movie.getPosterUri());
      movieDetailView.showMovieTitle(movie.getTitle());
      movieDetailView.showMovieYear(helper.getYearFromReleaseDate(movie.getReleaseDate()));
      movieDetailView.showMovieVoteAverage(helper.getVoteAverage(movie.getVoteAverage()));
      movieDetailView.showMovieOverview(movie.getOverview());
    }
  }
}
