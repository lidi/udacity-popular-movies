package pm.diu.liutauras.udacitypopularmovies.model.entities;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.parceler.Parcel;

@Parcel
public class Movie {

  private final static String IMAGE_BASE_URI = "http://image.tmdb.org/t/p/";
  private final static String SIZE = "w185";

  private Integer id;
  private String overview;
  private String poster_path;
  private String release_date;
  private String title;
  private Boolean video;
  private Float vote_average;

  public Movie() {}

  public Movie(Integer id,
      String title,
      String overview,
      String posterPath,
      String releaseDate,
      Float voteAverage,
      Boolean video) {
    this.id = id;
    this.title = title;
    this.overview = overview;
    this.poster_path = posterPath;
    this.release_date = releaseDate;
    this.vote_average = voteAverage;
    this.video = video;
  }

  public String getPosterUri(){
    return Joiner.on("").skipNulls().join(Lists.newArrayList(IMAGE_BASE_URI, SIZE, poster_path));
  }

  public Integer getId() {
    return id;
  }

  public String getOverview() {
    return overview;
  }

  public String getReleaseDate() {
    return release_date;
  }

  public String getTitle() {
    return title;
  }

  public Boolean getVideo() {
    return video;
  }

  public Float getVoteAverage() {
    return vote_average;
  }
}



