package news.factory.com.base.base_recycler.view_holders.home_news_categories;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.article_item.ArticleItemData;
import news.factory.com.model.Articles;
import news.factory.com.model.Category;


public class NewsCategoriesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recycler_home_categories)
    RecyclerView recyclerView;

    private List<RecyclerWrapper> dataList;

    private RecyclerAdapterImpl adapter;

    public NewsCategoriesHolder(View itemView, List<RecyclerWrapper> list) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.dataList = list;
        this.adapter = new RecyclerAdapterImpl(new Object());
        recyclerView.setAdapter(adapter);
    }


    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {

            NewsCategoriesData data = (NewsCategoriesData) dataList.get(position).getData();
            adapter.addItems(getArticleMappedList(data));
        }
    }

    private List<RecyclerWrapper> getArticleMappedList(NewsCategoriesData data) {

        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();

        for(int i=1; i<data.getArticles().size(); i++) {

           Articles articles = data.getArticles().get(i);

           recyclerWrappers.add(new RecyclerWrapper(new ArticleItemData(articles.getFeaturedImage().getS(), articles.getTitle(), articles.getCategory(), articles.getShares()), RecyclerWrapper.TYPE_ARTIClE_ITEM));
       }

        return recyclerWrappers;
    }

}
