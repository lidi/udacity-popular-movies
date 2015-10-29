package pm.diu.liutauras.udacitypopularmovies.ui.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import pm.diu.liutauras.udacitypopularmovies.R;

public class RecyclerInsetsDecoration extends RecyclerView.ItemDecoration {

  private int insets;

  public RecyclerInsetsDecoration(Context context) {
    insets = context.getResources().getDimensionPixelSize(R.dimen.insets);
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

    //We can supply forced insets for each item view here in the Rect
    super.getItemOffsets(outRect, view, parent, state);
    outRect.set(insets, insets, insets, insets);
  }
}