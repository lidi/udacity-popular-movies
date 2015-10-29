package pm.diu.liutauras.udacitypopularmovies.internal.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import pm.diu.liutauras.udacitypopularmovies.internal.di.Activity;

@Module
public class ActivityModule {
  private final Context context;

  public ActivityModule(Context context) {

    this.context = context;
  }

  @Provides @Activity
  Context provideActivityContext() {
    return context;
  }
}
