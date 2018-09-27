package news.factory.com.base.base_recycler.view_holders.home_page_categories;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.view_holders.article_text.ArticleTextData;

public class HomePageCategoryNameHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.category_name_home_page)
    TextView categoryName;

    private List<RecyclerWrapper> dataList;

    public HomePageCategoryNameHolder(View itemView, List<RecyclerWrapper> dataList ) {
        super(itemView);
        this.dataList = dataList;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
           HomePageCategoryNameData data = (HomePageCategoryNameData) dataList.get(position).getData();
            categoryName.setText((data.getName()));
        }
    }
}
