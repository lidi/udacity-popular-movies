package pm.diu.liutauras.udacitypopularmovies.views;

import android.app.ActivityOptions;
import java.util.List;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;

public interface MoviesListView extends BaseView {

  void bindMoviesList(List<Movie> movies);

  void showMovieList();

  void hideMovieList();

  //void showLoadingMoreMoviesIndicator();

  //void hideLoadingMoreMoviesIndicator();

  //void hideLoadingIndicator ();

  void showLoadingView();

  void hideLoadingView();

  //void showLightError();

  //void showErrorView(String errorMessage);

  //void hideErrorView();

  //void showEmptyIndicator();

  //void hideEmptyIndicator();

  //void updateMoviesList(int moviesLimit);

  ActivityOptions getActivityOptions(int position, android.view.View clickedView);
}
