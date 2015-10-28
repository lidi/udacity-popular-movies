package pm.diu.liutauras.udacitypopularmovies.model.entities;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class Poster {
  private String posterUri;

  private final static String IMAGE_BASE_URI = "http://image.tmdb.org/t/p/";
  private final static String SIZE = "w185";

  public Poster(String imageName){
    posterUri = Joiner.on("").skipNulls().join(Lists.newArrayList(IMAGE_BASE_URI, SIZE, imageName));
  }

  public String getPosterUri(){
    return posterUri;
  }
}
