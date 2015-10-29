package pm.diu.liutauras.udacitypopularmovies.model.repository;

import java.util.List;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import rx.Observable;

public interface Repository {
  Observable<List<Movie>> getMovies ();
}