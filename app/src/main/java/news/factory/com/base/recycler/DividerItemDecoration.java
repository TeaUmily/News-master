package news.factory.com.base.recycler;


import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {


    private final int verticalSpaceHeight;

    public DividerItemDecoration() {
        this.verticalSpaceHeight = 16;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()) {
            outRect.bottom = verticalSpaceHeight;
        }
    }




}
