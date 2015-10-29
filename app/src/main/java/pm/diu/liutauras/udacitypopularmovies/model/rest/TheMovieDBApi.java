package pm.diu.liutauras.udacitypopularmovies.model.rest;

import java.util.List;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface TheMovieDBApi {

  String BASE_URL = "http://api.themoviedb.org";

  @GET("3/discover/movie")
  Observable<List<Movie>> loadMovies(@Query("api_key") String api_key);

  @GET("3/discover/movie")
  Observable<List<Movie>> loadMovies(@Query("api_key") String api_key, @Query("page") int page);

}
