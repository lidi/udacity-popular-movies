package pm.diu.liutauras.udacitypopularmovies.presenters;

import android.content.Intent;
import android.view.View;

public interface Presenter {

    void onPause();

    void attachView (View v);

    void attachIncomingIntent (Intent intent);

    void onCreate();
}
