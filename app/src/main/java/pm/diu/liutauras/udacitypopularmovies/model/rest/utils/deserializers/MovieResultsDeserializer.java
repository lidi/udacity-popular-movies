package pm.diu.liutauras.udacitypopularmovies.model.rest.utils.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;

public class MovieResultsDeserializer implements JsonDeserializer<List<Movie>> {

  @Override
  public List<Movie> deserialize(JsonElement je, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {

    Type listType = new TypeToken<List<Movie>>() {}.getType();

    JsonElement results = je.getAsJsonObject().get("results");

    return new Gson().fromJson(results, listType);
  }
}
