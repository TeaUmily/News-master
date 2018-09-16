package news.factory.com.base_recycler;


import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import news.factory.com.R;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {


    private final int verticalSpaceHeight;


    public DividerItemDecoration(Context context) {
        this.verticalSpaceHeight = (int) context.getResources().getDimension(R.dimen.divider_space_height) ;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()) {
            outRect.bottom = verticalSpaceHeight;
        }
    }


}
