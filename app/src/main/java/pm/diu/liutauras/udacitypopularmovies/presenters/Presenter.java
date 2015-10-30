package pm.diu.liutauras.udacitypopularmovies.presenters;

import android.content.Intent;
import pm.diu.liutauras.udacitypopularmovies.views.BaseView;

public interface Presenter {

    void onStart();

    void onStop();

    void onPause();

    void attachView (BaseView v);

    void attachIncomingIntent (Intent intent);

    void onCreate();

    void onSortBy(String criteria);
}
