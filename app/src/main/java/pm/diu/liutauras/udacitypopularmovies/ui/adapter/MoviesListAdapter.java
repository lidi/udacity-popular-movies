package pm.diu.liutauras.udacitypopularmovies.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import java.util.List;
import pm.diu.liutauras.udacitypopularmovies.R;
import pm.diu.liutauras.udacitypopularmovies.model.entities.Movie;
import pm.diu.liutauras.udacitypopularmovies.ui.RecyclerClickListener;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.PosterViewHolder> {

  private final RecyclerClickListener recyclerClickListener;
  private final List<Movie> movies;

  private Context context;

  public MoviesListAdapter(List<Movie> movies, Context context, RecyclerClickListener recyclerClickListener) {
      this.context = context;
      this.movies = movies;
      this.recyclerClickListener = recyclerClickListener;
  }

  @Override
  public PosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_poster, parent, false);
    return new PosterViewHolder(view, recyclerClickListener);
  }

  @Override public void onBindViewHolder(PosterViewHolder holder, int position) {
    holder.bindMovie(movies.get(position));
  }

  @Override public int getItemCount() {
    return movies.size();
  }

  /**
   * Placeholder class
   */
  public class PosterViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.item_poster) ImageView moviePosterView;

    public PosterViewHolder(View itemView, final RecyclerClickListener recyclerClickListener) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      bindListener(itemView, recyclerClickListener);

    }

    public void bindMovie(Movie movie) {
      Glide.with(context)
          .load(movie.getPosterUri())
          .crossFade()
          .into(moviePosterView);
    }

    private void bindListener(View itemView, final RecyclerClickListener recyclerClickListener) {
      itemView.setOnClickListener(v ->
          recyclerClickListener.onElementClick(getAdapterPosition(), moviePosterView));
    }
  }
}
