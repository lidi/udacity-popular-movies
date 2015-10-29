package pm.diu.liutauras.udacitypopularmovies.internal.di.components;

import dagger.Component;
import pm.diu.liutauras.udacitypopularmovies.internal.di.Activity;
import pm.diu.liutauras.udacitypopularmovies.internal.di.modules.ActivityModule;
import pm.diu.liutauras.udacitypopularmovies.ui.activities.MoviesListActivity;

@Activity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface MoviesComponent extends ActivityComponent {

  void inject (MoviesListActivity activity);
}