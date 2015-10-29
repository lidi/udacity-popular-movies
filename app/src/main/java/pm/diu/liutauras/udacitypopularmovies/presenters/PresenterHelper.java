package pm.diu.liutauras.udacitypopularmovies.presenters;

import com.google.common.base.Joiner;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class PresenterHelper {

  public String getYearFromReleaseDate(String movieReleaseDate) {
    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    LocalDate date = formatter.parseLocalDate(movieReleaseDate);

    return String.valueOf(date.getYear());
  }

  public String getVoteAverage(Float voteAverage) {
    return Joiner.on("/").join(String.valueOf(voteAverage),"10");
  }
}
