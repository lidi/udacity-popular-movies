package pm.diu.liutauras.udacitypopularmovies.internal.di;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import pm.diu.liutauras.udacitypopularmovies.UdacityPopularMoviesApplication;
//import pm.diu.liutauras.udacitypopularmovies.model.repository.Repository;

@Module
public class AppModule {

  private final UdacityPopularMoviesApplication application;

  public AppModule(UdacityPopularMoviesApplication application) {
    this.application = application;
  }

  @Provides @Singleton UdacityPopularMoviesApplication provideUdacityPopularMoviesApplicationContext() {
    return application;
  }

  //@Provides @Singleton Repository provideDataRepository (RestRepository restRepository) {
  //  return restRepository;
  //}
}
