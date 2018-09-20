package news.factory.com.base.base_recycler.view_holders.article_author_shares;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_recycler.RecyclerWrapper;


public class ArticleAuthorAndSharesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.author_textView)
    TextView author;

    @BindView(R.id.shares_number_textView)
    TextView numberOfShares;

    private List<RecyclerWrapper> dataList;

    public ArticleAuthorAndSharesHolder(View itemView, List<RecyclerWrapper> dataList) {
        super(itemView);
        this.dataList = dataList;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleAuthorAndSharesData data = (ArticleAuthorAndSharesData) dataList.get(position).getData();
            author.setText(data.getAuthor());
            numberOfShares.setText(data.getNumberOfShares());
        }
    }

}
