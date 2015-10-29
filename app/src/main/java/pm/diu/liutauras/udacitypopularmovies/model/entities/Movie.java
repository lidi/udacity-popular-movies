package pm.diu.liutauras.udacitypopularmovies.model.entities;

import android.util.Log;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class Movie {

  public final static String [] THE_MOVIE_DB_API_MOVIE_FIELDS = {
      "id", "adult", "backdrop_path", "original_language", "original_title", "overview", "poster_path",
      "popularity", "release_date", "title", "video", "vote_average", "vote_count"
  };

  private final static String IMAGE_BASE_URI = "http://image.tmdb.org/t/p/";
  private final static String SIZE = "w185";

  private Integer id;
  private Boolean adult;
  private String backdrop_path;
  private String original_language;
  private String original_title;
  private String overview;
  private String poster_path;
  private Double popularity;
  private String release_date;
  private String title;
  private Boolean video;
  private Float vote_average;
  private Integer vote_count;

  public String getPosterUri(){
    Log.v("Poster uri", Joiner.on("").skipNulls().join(Lists.newArrayList(IMAGE_BASE_URI, SIZE, poster_path)));
    return Joiner.on("").skipNulls().join(Lists.newArrayList(IMAGE_BASE_URI, SIZE, poster_path));
  }

  public Boolean getAdult() {
    return adult;
  }

  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  public String getBackdropPath() {
    return backdrop_path;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdrop_path = backdropPath;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOriginalLanguage() {
    return original_language;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.original_language = originalLanguage;
  }

  public String getOriginalTitle() {
    return original_title;
  }

  public void setOriginalTitle(String originalTitle) {
    this.original_title = originalTitle;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getReleaseDate() {
    return release_date;
  }

  public void setReleaseDate(String releaseDate) {
    this.release_date = releaseDate;
  }

  public String getPosterPath() {
    return poster_path;
  }

  public void setPosterPath(String posterPath) {
    this.poster_path = posterPath;
  }

  public Double getPopularity() {
    return popularity;
  }

  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getVideo() {
    return video;
  }

  public void setVideo(Boolean video) {
    this.video = video;
  }

  public Float getVoteAverage() {
    return vote_average;
  }

  public void setVoteAverage(Float voteAverage) {
    this.vote_average = voteAverage;
  }

  public Integer getVoteCount() {
    return vote_count;
  }

  public void setVoteCount(Integer voteCount) {
    this.vote_count = voteCount;
  }


  //private List<Integer> genre_ids = new ArrayList<>();
  //public List<Integer> getGenreIds() {
  //  return genre_ids;
  //}
  //
  //public void setGenreIds(List<Integer> genreIds) {
  //  this.genre_ids = genreIds;
  //}

}



