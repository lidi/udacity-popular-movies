package pm.diu.liutauras.udacitypopularmovies.ui.activities;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.ProgressBar;
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
  @Bind(R.id.activity_movies_list_progress) ProgressBar moviesListProgressBar;
  @Bind(R.id.activity_loading_progress) View progressIndicator;
  @Bind(R.id.activity_movies_empty_indicator) View emptyIndicator;

  @Inject MoviesListPresenter moviesListPresenter;

  private MoviesListAdapter moviesListAdapter;
  private Snackbar loadingMoreMoviesSnack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
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
  protected void onStop() {
    super.onStop();
    moviesListPresenter.onStop();
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
    moviesListAdapter = new MoviesListAdapter(movies, this, moviesListPresenter);
    moviesRecycler.setAdapter(moviesListAdapter);
  }

  @Override public void showMovieList() {
    if (moviesRecycler.getVisibility() == View.GONE ||
        moviesRecycler.getVisibility() == View.INVISIBLE) {

      moviesRecycler.setVisibility(View.VISIBLE);
    }
  }

  @Override public void hideMovieList() {
    moviesRecycler.setVisibility(View.GONE);
  }

  @Override public void showLoadingView() {
    progressIndicator.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoadingView() {
    progressIndicator.setVisibility(View.GONE);
  }

  @Override public void updateMoviesList(int moviesAdded) {
    moviesListAdapter.notifyItemRangeChanged(moviesListAdapter.getItemCount() + moviesAdded, moviesAdded);
  }

  @Override public void showLoadingMoreMoviesIndicator() {
    loadingMoreMoviesSnack = Snackbar.make(moviesRecycler,
        getString(R.string.message_loading_more_movies), Snackbar.LENGTH_INDEFINITE);

    loadingMoreMoviesSnack.show();
  }

  @Override public void hideLoadingMoreMoviesIndicator() {
    if (loadingMoreMoviesSnack != null) loadingMoreMoviesSnack.dismiss();
  }

  @Override public void hideLoadingIndicator() {
    loadingMoreMoviesSnack.dismiss();
  }

  @Override public void showEmptyIndicator() {
    emptyIndicator.setVisibility(View.VISIBLE);
  }

  @Override public void hideEmptyIndicator() {
    emptyIndicator.setVisibility(View.GONE);
  }

  @Override public ActivityOptions getActivityOptions(int position, View clickedView) {
    return ActivityOptions.makeSceneTransitionAnimation(
        this, clickedView, "RecyclerInsetsDecoration");
  }
}

