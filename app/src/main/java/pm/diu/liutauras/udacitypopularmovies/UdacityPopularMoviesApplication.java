package pm.diu.liutauras.udacitypopularmovies;

import android.app.Application;
import pm.diu.liutauras.udacitypopularmovies.internal.di.AppModule;
import pm.diu.liutauras.udacitypopularmovies.internal.di.components.AppComponent;
import pm.diu.liutauras.udacitypopularmovies.internal.di.components.DaggerAppComponent;

public class UdacityPopularMoviesApplication extends Application {
  private AppComponent appComponent;

  @Override
  public void onCreate() {

    super.onCreate();
    initializeInjector();
  }

  private void initializeInjector() {

    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
  }

  public AppComponent getAppComponent() {

    return appComponent;
  }
}
