package news.factory.com.base.base_recycler.view_holders.article_text;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.view_holders.article_text.ArticleTextData;

public class ArticleTextHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.textView_item_article)TextView text;

    private List<RecyclerWrapper> dataList;

    public ArticleTextHolder(View itemView, List<RecyclerWrapper> dataList) {
        super(itemView);
        this.dataList = dataList;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleTextData data = (ArticleTextData) dataList.get(position).getData();
            text.setText(Html.fromHtml(data.getText()));
        }
    }
}
