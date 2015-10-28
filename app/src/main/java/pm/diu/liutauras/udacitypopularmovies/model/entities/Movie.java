package pm.diu.liutauras.udacitypopularmovies.model.entities;

public class Movie {

  public final static String [] THE_MOVIE_DB_API_MOVIE_FIELDS = {
      "id", "adult", "backdrop_path", "original_language", "original_title", "overview", "poster_path",
      "popularity", "release_date", "title", "video", "vote_average", "vote_count"
  };

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

  //private List<Integer> genre_ids = new ArrayList<>();

  /**
   *
   * @return
   *     The adult
   */
  public Boolean getAdult() {
    return adult;
  }

  /**
   *
   * @param adult
   *     The adult
   */
  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  /**
   *
   * @return
   *     The backdrop_path
   */
  public String getBackdropPath() {
    return backdrop_path;
  }

  /**
   *
   * @param backdropPath
   *     The backdropPath
   */
  public void setBackdropPath(String backdropPath) {
    this.backdrop_path = backdropPath;
  }

   /**
   *
   * @return
   *     The id
   */
  public Integer getId() {
    return id;
  }

  /**
   *
   * @param id
   *     The id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   *
   * @return
   *     The original_language
   */
  public String getOriginalLanguage() {
    return original_language;
  }

  /**
   *
   * @param originalLanguage
   *     The originalLanguage
   */
  public void setOriginalLanguage(String originalLanguage) {
    this.original_language = originalLanguage;
  }

  /**
   *
   * @return
   *     The original_title
   */
  public String getOriginalTitle() {
    return original_title;
  }

  /**
   *
   * @param originalTitle
   *     The originalTitle
   */
  public void setOriginalTitle(String originalTitle) {
    this.original_title = originalTitle;
  }

  /**
   *
   * @return
   *     The overview
   */
  public String getOverview() {
    return overview;
  }

  /**
   *
   * @param overview
   *     The overview
   */
  public void setOverview(String overview) {
    this.overview = overview;
  }

  /**
   *
   * @return
   *     The release_date
   */
  public String getReleaseDate() {
    return release_date;
  }

  /**
   *
   * @param releaseDate
   *     The releaseDate
   */
  public void setReleaseDate(String releaseDate) {
    this.release_date = releaseDate;
  }

  /**
   *
   * @return
   *     The poster_path
   */
  public String getPosterPath() {
    return poster_path;
  }

  /**
   *
   * @param posterPath
   *     The posterPath
   */
  public void setPosterPath(String posterPath) {
    this.poster_path = posterPath;
  }

  /**
   *
   * @return
   *     The popularity
   */
  public Double getPopularity() {
    return popularity;
  }

  /**
   *
   * @param popularity
   *     The popularity
   */
  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  /**
   *
   * @return
   *     The title
   */
  public String getTitle() {
    return title;
  }

  /**
   *
   * @param title
   *     The title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   *
   * @return
   *     The video
   */
  public Boolean getVideo() {
    return video;
  }

  /**
   *
   * @param video
   *     The video
   */
  public void setVideo(Boolean video) {
    this.video = video;
  }

  /**
   *
   * @return
   *     The vote_average
   */
  public Float getVoteAverage() {
    return vote_average;
  }

  /**
   *
   * @param voteAverage
   *     The voteAverage
   */
  public void setVoteAverage(Float voteAverage) {
    this.vote_average = voteAverage;
  }

  /**
   *
   * @return
   *     The vote_count
   */
  public Integer getVoteCount() {
    return vote_count;
  }

  /**
   *
   * @param voteCount
   *     The voteCount
   */
  public void setVoteCount(Integer voteCount) {
    this.vote_count = voteCount;
  }

  ///**
  // *
  // * @return
  // *     The genre_ids
  // */
  //public List<Integer> getGenreIds() {
  //  return genre_ids;
  //}
  //
  ///**
  // *
  // * @param genreIds
  // *     The genreIds
  // */
  //public void setGenreIds(List<Integer> genreIds) {
  //  this.genre_ids = genreIds;
  //}

}



