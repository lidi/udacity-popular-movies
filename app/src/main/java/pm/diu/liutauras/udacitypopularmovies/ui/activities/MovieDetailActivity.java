package pm.diu.liutauras.udacitypopularmovies.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import pm.diu.liutauras.udacitypopularmovies.R;
import pm.diu.liutauras.udacitypopularmovies.presenters.MovieDetailPresenter;
import pm.diu.liutauras.udacitypopularmovies.views.MovieDetailView;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailView {

  MovieDetailPresenter movieDetailPresenter = new MovieDetailPresenter();

  @Bind(R.id.movie_detail_poster) ImageView movieDetailPoster;
  @Bind(R.id.movie_detail_title) TextView movieDetailTitle;
  @Bind(R.id.movie_detail_year) TextView movieDetailYear;
  @Bind(R.id.movie_detail_votes) TextView moveDetailVotes;
  @Bind(R.id.movie_detail_overview) TextView movieDetailOverview;

  @Override
  public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_detail);
    ButterKnife.bind(this);

    initializePresenter();
  }

  private void initializePresenter(){
    movieDetailPresenter.attachView(this);
    movieDetailPresenter.attachIncomingIntent(getIntent());
    movieDetailPresenter.initializePresenter();
  }

  @Override public void showMoviePoster(String url) {
    Glide.with(this).load(url).placeholder(R.drawable.no_poster).into(movieDetailPoster);
  }

  @Override public void showMovieTitle(String title) {
    movieDetailTitle.setText(title);
  }

  @Override public void showMovieYear(String year) {
    movieDetailYear.setText(year);
  }

  @Override public void showMovieOverview(String overview) {
    movieDetailOverview.setText(overview);
  }

  @Override public void showMovieVoteAverage(String voteAverage) {
    moveDetailVotes.setText(voteAverage);
  }

  public void markAsFavorite(View view){
    Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
  }
}
