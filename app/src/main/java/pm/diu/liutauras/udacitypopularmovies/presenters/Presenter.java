package pm.diu.liutauras.udacitypopularmovies.presenters;

import android.content.Intent;
import pm.diu.liutauras.udacitypopularmovies.views.View;

public interface Presenter {

    void onStart();

    void onStop();

    void onPause();

    void attachView (View v);

    void attachIncomingIntent (Intent intent);

    void onCreate();
}
