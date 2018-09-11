package news.factory.com.base_recycler.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import news.factory.com.base_recycler.RecyclerWrapper;
import news.factory.com.base_recycler.recycler.view_holders.article_author_shares.ArticleAuthorAndSharesHolder;
import news.factory.com.base_recycler.recycler.view_holders.article_featured_image.ArticleFeaturedImageHolder;
import news.factory.com.base_recycler.recycler.view_holders.article_image.ArticleImageHolder;
import news.factory.com.base_recycler.recycler.view_holders.article_page_indicator.ArticlePageIndicatorHolder;
import news.factory.com.base_recycler.recycler.view_holders.article_publication_date.ArticlePublicationDateHolder;
import news.factory.com.base_recycler.recycler.view_holders.article_text.ArticleTextHolder;
import news.factory.com.base_recycler.recycler.view_holders.article_title.ArticleTitleHolder;
import news.factory.com.base_recycler.recycler.view_holders.article_upper_tittle.ArticleUpperTitleHolder;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<RecyclerWrapper> dataList;

    public RecyclerAdapter() {
        dataList = new ArrayList<>();
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
                return new ArticleImageHolder(view, dataList);

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


    class EmptyViewHolder extends RecyclerView.ViewHolder{
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

}


