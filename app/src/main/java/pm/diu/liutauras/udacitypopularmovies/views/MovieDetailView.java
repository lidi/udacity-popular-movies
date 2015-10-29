package pm.diu.liutauras.udacitypopularmovies.views;

public interface MovieDetailView extends BaseView {
  void showMoviePoster (String url);
  void showMovieTitle (String title);
  void showMovieYear (String year);
  void showMovieOverview (String overview);
  void showMovieVoteAverage (String voteAverage);
}
