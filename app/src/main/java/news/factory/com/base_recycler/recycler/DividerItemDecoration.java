package news.factory.com.base_recycler.recycler;


import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import news.factory.com.App;
import news.factory.com.R;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {


    private final int verticalSpaceHeight;

    public DividerItemDecoration() {
        this.verticalSpaceHeight = (int) App.getInstance().getResources().getDimension(R.dimen.divider_space_height) ;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()) {
            outRect.bottom = verticalSpaceHeight;
        }
    }


}
