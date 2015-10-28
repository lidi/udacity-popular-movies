package pm.diu.liutauras.udacitypopularmovies.ui.activities;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;
import pm.diu.liutauras.udacitypopularmovies.R;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.presenters.MoviesListPresenter;
import pm.diu.liutauras.udacitypopularmovies.views.MoviesListView;

public class MoviesListActivity extends AppCompatActivity implements MoviesListView {
  @Bind(R.id.activity_movies_recycler) RecyclerView activity_movies_recycler;

  @Inject MoviesListPresenter moviesListPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movies_list);
    ButterKnife.bind(this);
  }

  @Override public void bindMoviesList(List<Movie> movies) {

  }

  @Override public void showMovieList() {

  }

  @Override public void hideMovieList() {

  }

  @Override public void showLoadingView() {

  }

  @Override public void hideLoadingView() {

  }

  @Override public void updateMoviesList(int moviesLimit) {

  }

  @Override public ActivityOptions getActivityOptions(int position, View clickedView) {
    return null;
  }
}


//package pm.diu.liutauras.popularmoviesapp.activities;
//
//    import android.os.Bundle;
//    import android.support.v7.app.AppCompatActivity;
//    import android.support.v7.widget.GridLayoutManager;
//    import android.support.v7.widget.RecyclerView;
//    import android.util.Log;
//    import android.view.Menu;
//    import android.view.MenuItem;
//
//    import java.util.ArrayList;
//    import java.util.List;
//
//    import butterknife.Bind;
//    import butterknife.ButterKnife;
//    import pm.diu.liutauras.popularmoviesapp.adapter.MainGridAdapter;
//    import pm.diu.liutauras.popularmoviesapp.model.Movie;
//    import pm.diu.liutauras.popularmoviesapp.model.Poster;
//    import pm.diu.liutauras.popularmoviesapp.R;
//    import pm.diu.liutauras.popularmoviesapp.model.Result;
//    import pm.diu.liutauras.popularmoviesapp.service.TheMovieDBService;
//    import rx.Subscriber;
//    import rx.android.schedulers.AndroidSchedulers;
//    import rx.schedulers.Schedulers;
//
//public class MainActivity extends AppCompatActivity {
//
//  @Bind(R.id.main_grid) RecyclerView mainGrid;
//
//  /**
//   * Number of columns in the grid
//   */
//  private static final int numColumns = 2;
//
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_main);
//
//    ButterKnife.bind(this);
//
//    mainGrid.setHasFixedSize(true);
//    mainGrid.setLayoutManager(new GridLayoutManager(this, numColumns, GridLayoutManager.VERTICAL, false));
//
//    final MainGridAdapter adapter = new MainGridAdapter();
//    mainGrid.setAdapter(adapter);
//
//    TheMovieDBService client = new TheMovieDBService();
//    String api_key = getResources().getString(R.string.tmd_api_key);
//    client.getService().loadMovies(api_key)
//        .subscribeOn(Schedulers.newThread())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Subscriber<Movie>() {
//          @Override
//          public void onCompleted() {
//
//          }
//
//          @Override
//          public void onError(Throwable e) {
//            Log.e("TheMovieDbAPI Error", e.getMessage());
//          }
//
//          @Override
//          public void onNext(Movie movie) {
//            adapter.addData(getsPosters(movie));
//          }
//
//          private List<Poster> getsPosters(Movie movie) {
//            List<Poster> posters = new ArrayList<>();
//
//            for (Result result : movie.getResults()) {
//              Poster poster = new Poster(result.getPosterPath(), result);
//              posters.add(poster);
//            }
//            return posters;
//          }
//        });
//  }
//
//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//    // Inflate the menu; this adds items to the action bar if it is present.
//    getMenuInflater().inflate(R.menu.menu_main, menu);
//    return true;
//  }
//
//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//    // Handle action bar item clicks here. The action bar will
//    // automatically handle clicks on the Home/Up button, so long
//    // as you specify a parent activity in AndroidManifest.xml.
//    int id = item.getItemId();
//
//    //noinspection SimplifiableIfStatement
//    if (id == R.id.action_settings) {
//      return true;
//    }
//
//    return super.onOptionsItemSelected(item);
//  }
//}
