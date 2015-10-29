package pm.diu.liutauras.udacitypopularmovies.presenters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import pm.diu.liutauras.udacitypopularmovies.views.BaseView;
import pm.diu.liutauras.udacitypopularmovies.views.MovieDetailView;

public class MovieDetailPresenter implements Presenter, AdapterView.OnItemSelectedListener {

  private final Context context;
  private MovieDetailView movieDetailView;
  private Intent intent;

  public MovieDetailPresenter(Context context) {
    this.context = context;
  }

  @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

  }

  @Override public void onNothingSelected(AdapterView<?> parent) {

  }

  @Override public void onStart() {

  }

  @Override public void onStop() {

  }

  @Override public void onPause() {

  }

  @Override public void attachView(BaseView v) {
    movieDetailView = (MovieDetailView) v;
  }

  @Override public void attachIncomingIntent(Intent intent) {
    this.intent = intent;
  }

  @Override public void onCreate() {

  }

  public void initializePresenter() {
  }
}
