package pm.diu.liutauras.udacitypopularmovies.model.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import javax.inject.Inject;
import pm.diu.liutauras.udacitypopularmovies.Key;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.model.repository.Repository;
import pm.diu.liutauras.udacitypopularmovies.model.rest.utils.deserializers.MovieResultsDeserializer;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;

public class RestRepository implements Repository{


  private final TheMovieDBApi theMovieDBApi;

  @Inject public RestRepository() {

    Gson gson = new GsonBuilder()
        .registerTypeAdapter(new TypeToken<List<Movie>>() {}.getType(), new MovieResultsDeserializer())
        .create();

    Retrofit theMovieDBApiAdapter = new Retrofit.Builder()
        .baseUrl(TheMovieDBApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    theMovieDBApi =  theMovieDBApiAdapter.create(TheMovieDBApi.class);
  }
  @Override public Observable<List<Movie>> getMovies() {
    return theMovieDBApi.loadMovies(Key.KEY);
  }

  @Override public Observable<List<Movie>> getNextMoviesPage(int page) {
    return theMovieDBApi.loadMovies(Key.KEY, page);
  }
}
