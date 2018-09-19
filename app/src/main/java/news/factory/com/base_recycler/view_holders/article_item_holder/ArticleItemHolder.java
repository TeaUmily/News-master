package news.factory.com.base_recycler.view_holders.article_item_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import news.factory.com.base_recycler.RecyclerWrapper;

public class ArticleItemHolder extends RecyclerView.ViewHolder {


    List<RecyclerWrapper> dataList;

    public ArticleItemHolder(View itemView, List<RecyclerWrapper> list) {
        super(itemView);
        this.dataList = list;
    }

    public void onBind(int position) {

    }
}
