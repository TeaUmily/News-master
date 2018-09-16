package news.factory.com.base_recycler.view_holders.article_publication_date;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.App;
import news.factory.com.R;
import news.factory.com.base_recycler.RecyclerWrapper;
import news.factory.com.base_recycler.view_holders.article_publication_date.ArticlePublicationDateData;

public class ArticlePublicationDateHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.publication_date_textView)
    TextView publicationDate;

    private List<RecyclerWrapper> dataList;

    public ArticlePublicationDateHolder(View itemView,List<RecyclerWrapper> dataList) {
        super(itemView);
        this.dataList = dataList;
        ButterKnife.bind(this,itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticlePublicationDateData data = (ArticlePublicationDateData) dataList.get(position).getData();


            this.publicationDate.setText(data.getPublicationDate());
        }
    }
}
