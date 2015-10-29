package pm.diu.liutauras.udacitypopularmovies.ui.activities;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;
import pm.diu.liutauras.udacitypopularmovies.R;
import pm.diu.liutauras.udacitypopularmovies.UdacityPopularMoviesApplication;
import pm.diu.liutauras.udacitypopularmovies.internal.di.components.DaggerMoviesComponent;
import pm.diu.liutauras.udacitypopularmovies.internal.di.modules.ActivityModule;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.presenters.MoviesListPresenter;
import pm.diu.liutauras.udacitypopularmovies.ui.adapter.MoviesListAdapter;
import pm.diu.liutauras.udacitypopularmovies.ui.views.RecyclerInsetsDecoration;
import pm.diu.liutauras.udacitypopularmovies.views.MoviesListView;

public class MoviesListActivity extends AppCompatActivity implements MoviesListView {

  @Bind(R.id.activity_movies_recycler) RecyclerView moviesRecycler;

  @Inject MoviesListPresenter moviesListPresenter;

  private MoviesListAdapter movieListAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.v("#L#", "Creating");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movies_list);
    ButterKnife.bind(this);


    initializeDependencyInjector();
    initializeRecyclerView();
    initializePresenter();
  }

  @Override
  protected void onStart() {
    super.onStart();
    moviesListPresenter.onStart();
  }

  @Override
  protected void onPause(){
    super.onPause();
    moviesListPresenter.onPause();
  }

  private void initializeRecyclerView() {
    moviesRecycler.setLayoutManager(
        new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    moviesRecycler.addItemDecoration(new RecyclerInsetsDecoration(this));
    moviesRecycler.addOnScrollListener(mOnScrollListener);
  }

  private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
      GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
      int visibleItemsCount   = layoutManager.getChildCount();
      int totalItemsCount     = layoutManager.getItemCount();
      int firstVisibleItemPos = layoutManager.findFirstVisibleItemPosition();

      if (visibleItemsCount + firstVisibleItemPos >= totalItemsCount) {
        moviesListPresenter.onListEndReached();
      }
    }
  };

  private void initializePresenter() {
    Log.v("#L#", "Init presenter");
    moviesListPresenter.attachView(this);
    moviesListPresenter.onCreate();
  }

  private void initializeDependencyInjector() {
    UdacityPopularMoviesApplication popularMoviesApplication = (UdacityPopularMoviesApplication) getApplication();

    DaggerMoviesComponent.builder()
        .activityModule(new ActivityModule(this))
        .appComponent(popularMoviesApplication.getAppComponent())
        .build().inject(this);
  }

  @Override public void bindMoviesList(List<Movie> movies) {
    Log.v("#L#", String.valueOf(movies.size()));
    movieListAdapter = new MoviesListAdapter(movies,
        this, moviesListPresenter);

    moviesRecycler.setAdapter(movieListAdapter);
  }

  @Override public void showMovieList() {
    Log.v("#L#", "Showing");
    if (moviesRecycler.getVisibility() == View.GONE ||
        moviesRecycler.getVisibility() == View.INVISIBLE) {

      moviesRecycler.setVisibility(View.VISIBLE);
    }
  }

  @Override public void hideMovieList() {
    moviesRecycler.setVisibility(View.GONE);
  }

  @Override public void showLoadingView() {

  }

  @Override public void hideLoadingView() {

  }

  //@Override public void updateMoviesList(int moviesLimit) {
  //
  //}

  @Override public ActivityOptions getActivityOptions(int position, View clickedView) {
    return ActivityOptions.makeSceneTransitionAnimation(
        this, clickedView, "RecyclerInsetsDecoration");
  }
}

