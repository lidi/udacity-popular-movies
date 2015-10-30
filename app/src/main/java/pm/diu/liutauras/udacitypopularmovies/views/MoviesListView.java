package pm.diu.liutauras.udacitypopularmovies.views;

import android.app.ActivityOptions;
import java.util.List;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;

public interface MoviesListView extends BaseView {

  void bindMoviesList(List<Movie> movies);

  void showMovieList();

  void hideMovieList();

  void showLoadingView();

  void hideLoadingView();

  void updateMoviesList(int moviesLimit);

  void showLoadingMoreMoviesIndicator();

  void hideLoadingMoreMoviesIndicator();

  void hideLoadingIndicator ();

  void showEmptyIndicator();

  void hideEmptyIndicator();

  ActivityOptions getActivityOptions(int position, android.view.View clickedView);
}
