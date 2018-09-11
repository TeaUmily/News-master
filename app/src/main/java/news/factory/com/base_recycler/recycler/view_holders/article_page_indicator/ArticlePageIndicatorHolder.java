package news.factory.com.base_recycler.recycler.view_holders.article_page_indicator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base_recycler.recycler.RecyclerWrapper;

public class ArticlePageIndicatorHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.page_indicator_textView)
    TextView pageIndicator;

    private List<RecyclerWrapper> dataList;

    public ArticlePageIndicatorHolder(View itemView, List<RecyclerWrapper> dataList ) {
        super(itemView);
        this.dataList = dataList;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
            if (position != RecyclerView.NO_POSITION) {
                ArticlePageIndicatorData data = (ArticlePageIndicatorData) dataList.get(position).getData();
                pageIndicator.setText(data.getPageIndicator()+"/"+ data.getNumberOfPages());
        }
    }
}
