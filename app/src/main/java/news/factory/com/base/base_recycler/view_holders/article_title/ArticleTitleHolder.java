package news.factory.com.base.base_recycler.view_holders.article_title;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.view_holders.article_title.ArticleTitleData;

public class ArticleTitleHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.article_title_textView)
    TextView title;

    private List<RecyclerWrapper> dataList;

    public ArticleTitleHolder(View itemView, List<RecyclerWrapper> dataArray) {
        super(itemView);
        this.dataList = dataArray;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleTitleData data = (ArticleTitleData) dataList.get(position).getData();
            title.setText(data.getTitle());
        }
    }
}
