package pm.diu.liutauras.udacitypopularmovies.domain;

import rx.Observable;

public interface Usecase<T> {
  Observable<T> execute();
}
