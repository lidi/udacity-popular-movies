package pm.diu.liutauras.udacitypopularmovies.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import javax.inject.Inject;
import pm.diu.liutauras.udacitypopularmovies.R;
import pm.diu.liutauras.udacitypopularmovies.presenters.MovieDetailPresenter;
import pm.diu.liutauras.udacitypopularmovies.views.MovieDetailView;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailView {

  @Inject MovieDetailPresenter movieDetailPresenter;

  @Bind(R.id.movie_detail_poster)
  ImageView movieDetailPoster;

  @Override
  public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_detail);
    ButterKnife.bind(this);

  }

  @Override public void showMoviePoster(String url) {

  }

  @Override public void showMovieTitle(String title) {

  }

  @Override public void showMovieYear(String year) {

  }

  @Override public void showMovieOverview(String overview) {

  }

  @Override public void showMovieVoteAverage(String voteAverage) {

  }
}
