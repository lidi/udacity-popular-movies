package pm.diu.liutauras.udacitypopularmovies;

import pm.diu.liutauras.udacitypopularmovies.internal.di.AppModule;
import pm.diu.liutauras.udacitypopularmovies.internal.di.components.AppComponent;
import pm.diu.liutauras.udacitypopularmovies.internal.di.components.DaggerAppComponent;

public class UdacityPopularMoviesApplication extends android.app.Application {
  private AppComponent mAppComponent;

  @Override
  public void onCreate() {

    super.onCreate();
    initializeInjector();
  }

  private void initializeInjector() {

    mAppComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
  }

  public AppComponent getAppComponent() {

    return mAppComponent;
  }
}
