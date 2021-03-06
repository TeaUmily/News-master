package news.factory.com.base.base_recycler.view_holders.article_upper_tittle;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.view_holders.article_upper_tittle.ArticleUpperTitleData;


public class ArticleUpperTitleHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.upper_title_textView)
    TextView upperTittle;

    private List<RecyclerWrapper> dataList;

    public ArticleUpperTitleHolder(View itemView, List<RecyclerWrapper> dataList) {
        super(itemView);
        this.dataList = dataList;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleUpperTitleData data = (ArticleUpperTitleData) dataList.get(position).getData();
            upperTittle.setText(data.getUpperTitle());
        }
    }
}
