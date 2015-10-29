package pm.diu.liutauras.udacitypopularmovies.internal.di.components;

import dagger.Component;
import javax.inject.Singleton;
import pm.diu.liutauras.udacitypopularmovies.UdacityPopularMoviesApplication;
import pm.diu.liutauras.udacitypopularmovies.internal.di.AppModule;
import pm.diu.liutauras.udacitypopularmovies.model.repository.Repository;

@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
  UdacityPopularMoviesApplication app();
  Repository dataRepository();
}
