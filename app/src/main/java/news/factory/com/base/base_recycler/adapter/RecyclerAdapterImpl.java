package news.factory.com.base.base_recycler.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.view_holders.article_author_shares.ArticleAuthorAndSharesHolder;
import news.factory.com.base.base_recycler.view_holders.article_categories.ArticleCategoriesHolder;
import news.factory.com.base.base_recycler.view_holders.article_categories.CategoriesPagerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.article_featured_image.ArticleFeaturedImageHolder;
import news.factory.com.base.base_recycler.view_holders.article_image.ArticleImageHolder;
import news.factory.com.base.base_recycler.view_holders.article_item.ArticleItemHolder;
import news.factory.com.base.base_recycler.view_holders.article_page_indicator.ArticlePageIndicatorHolder;
import news.factory.com.base.base_recycler.view_holders.article_publication_date.ArticlePublicationDateHolder;
import news.factory.com.base.base_recycler.view_holders.article_text.ArticleTextHolder;
import news.factory.com.base.base_recycler.view_holders.article_title.ArticleTitleHolder;
import news.factory.com.base.base_recycler.view_holders.article_upper_tittle.ArticleUpperTitleHolder;
import news.factory.com.base.base_recycler.view_holders.home_page.HomePageViewHolder;
import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePagerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.home_page_all_articles.AllArticlesHolder;
import news.factory.com.base.base_recycler.view_holders.home_page_categories.HomePageCategoryNameHolder;

public class RecyclerAdapterImpl extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RecyclerAdapter {

    private List<RecyclerWrapper> dataList;
    private Object presenter;

    private CategoriesPagerAdapterImpl categoriesPagerAdapter;
    private HeaderHomePagerAdapterImpl headerHomePageAdapter;

    @Inject
    public RecyclerAdapterImpl(Object presenter) {
        dataList = new ArrayList<>();
        this.presenter = presenter;
    }

    public void addItems(List<RecyclerWrapper>  items){
        dataList.clear();
        dataList.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        switch(viewType){
            case RecyclerWrapper.TYPE_FEATURED_IMAGE:
                return new ArticleFeaturedImageHolder(view, dataList);

            case RecyclerWrapper.TYPE_IMAGE:
                return new ArticleImageHolder(view, dataList, presenter);

            case RecyclerWrapper.TYPE_TEXT:
                return new ArticleTextHolder(view, dataList);

            case RecyclerWrapper.TYPE_TITLE:
                return new ArticleTitleHolder(view, dataList);

            case RecyclerWrapper.TYPE_UPPER_TITLE:
                return new ArticleUpperTitleHolder(view, dataList);

            case RecyclerWrapper.TYPE_AUTHOR:
                return new ArticleAuthorAndSharesHolder(view, dataList);

            case RecyclerWrapper.TYPE_PUBLICATION_DATE:
                return new ArticlePublicationDateHolder(view, dataList);

            case RecyclerWrapper.TYPE_PAGE_INDICATOR:
                return new ArticlePageIndicatorHolder(view, dataList);

           case RecyclerWrapper.TYPE_ARTICLE_CATEGORIES:
                return new ArticleCategoriesHolder(view, categoriesPagerAdapter);

            case RecyclerWrapper.TYPE_ARTIClE_ITEM:
                return new ArticleItemHolder(view, dataList, presenter);

            case RecyclerWrapper.TYPE_HOME_PAGE_HEADER:
                return new HomePageViewHolder(presenter,view, headerHomePageAdapter, dataList);

            case RecyclerWrapper.TYPE_HOME_PAGE_CATEGORY:
                return new HomePageCategoryNameHolder(view, dataList);

            case RecyclerWrapper.TYPE_HOME_PAGE_ALL_ARTICLES:
                return new AllArticlesHolder(view);


            default: return new EmptyViewHolder(new View(parent.getContext()));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch(holder.getItemViewType()){
            case RecyclerWrapper.TYPE_FEATURED_IMAGE:
                ArticleFeaturedImageHolder featuredImageHolder = (ArticleFeaturedImageHolder) holder;
                featuredImageHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_IMAGE:
                ArticleImageHolder imageHolder = (ArticleImageHolder) holder;
                imageHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_TEXT:
                ArticleTextHolder textHolder = (ArticleTextHolder) holder;
                textHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_TITLE:
                ArticleTitleHolder titleHolder = (ArticleTitleHolder) holder;
                titleHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_UPPER_TITLE:
                ArticleUpperTitleHolder upperTitleHolder = (ArticleUpperTitleHolder) holder;
                upperTitleHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_AUTHOR:
                ArticleAuthorAndSharesHolder authorHolder = (ArticleAuthorAndSharesHolder) holder;
                authorHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_PUBLICATION_DATE:
                ArticlePublicationDateHolder dateHolder = (ArticlePublicationDateHolder) holder;
                dateHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_PAGE_INDICATOR:
                ArticlePageIndicatorHolder counterHolder = (ArticlePageIndicatorHolder) holder;
                counterHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_ARTICLE_CATEGORIES:
                ArticleCategoriesHolder categoriesHolder = (ArticleCategoriesHolder) holder;
                categoriesHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_ARTIClE_ITEM:
                ArticleItemHolder articleItemHolder = (ArticleItemHolder) holder;
                articleItemHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_HOME_PAGE_HEADER:
                HomePageViewHolder homePageViewHolder = (HomePageViewHolder) holder;
                homePageViewHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_HOME_PAGE_CATEGORY:
               HomePageCategoryNameHolder homeCategoriesHolder = (HomePageCategoryNameHolder) holder;
                homeCategoriesHolder.onBind(position);
                break;

            case RecyclerWrapper.TYPE_HOME_PAGE_ALL_ARTICLES:
                AllArticlesHolder allArticlesHolder = (AllArticlesHolder) holder;
                allArticlesHolder.onBind(position);
                break;


        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }


    public void setHeaderHomePageAdapter(HeaderHomePagerAdapterImpl headerHomePageAdapter) {
        this.headerHomePageAdapter = headerHomePageAdapter;
    }


    class EmptyViewHolder extends RecyclerView.ViewHolder{
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setViewPagerAdapter(CategoriesPagerAdapterImpl adapter){
        this.categoriesPagerAdapter = adapter;
    }

}