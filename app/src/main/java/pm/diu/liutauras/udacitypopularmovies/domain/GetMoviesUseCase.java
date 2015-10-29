package pm.diu.liutauras.udacitypopularmovies.domain;

import java.util.List;
import javax.inject.Inject;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.model.repository.Repository;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetMoviesUsecase implements Usecase<List<Movie>> {

  private final Repository repository;

  @Inject
  public GetMoviesUsecase(Repository repository) {
    this.repository = repository;
  }

  @Override
  public Observable<List<Movie>> execute() {
    return repository.getMovies()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
