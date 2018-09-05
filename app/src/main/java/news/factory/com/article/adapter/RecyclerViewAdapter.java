package news.factory.com.article.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.App;
import news.factory.com.R;
import news.factory.com.article.model.Content;
import news.factory.com.article.model.articleListItem.ArticleListItemImage;
import news.factory.com.article.model.articleListItem.ArticleListItemTitle;
import news.factory.com.article.model.articleListItem.ArticleListItem;
import news.factory.com.constants.Constants;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ArticleListItem> mItems;

    public RecyclerViewAdapter() {
        mItems = new ArrayList<>();
    }

    public void addItems(List<ArticleListItem> items){
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == Constants.ARTICLE_VIEW_TYPE_TITLE) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_header_title, parent, false);
            return new TitleHeaderArticleViewHolder(itemView);
        }
        if (viewType == Constants.ARTICLE_VIEW_TYPE_TEXT) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_article_text, parent, false);
            return new TextTypeArticleViewHolder(itemView);
        }
        if (viewType == Constants.ARTICLE_VIEW_TYPE_IMAGE) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_article_image, parent, false);
            return new ImageTypeArticleViewHolder(itemView);
        }

        return new EmptyViewHolder(new View(App.getInstance()));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if(mItems.get(position).getClass() == Content.class){

            Content c = (Content) mItems.get(position);

            if(c.getType().equals(Constants.ARTICLE_TYPE_IMAGE)){

                ImageTypeArticleViewHolder imageViewHolder = (ImageTypeArticleViewHolder) holder;
                Glide.with(App.getInstance()).load(Constants.IMAGE_BASE_URL + c.getImage().getOriginal()).into(imageViewHolder.mImageView);
                }

            else if(c.getType().equals(Constants.ARTICLE_TYPE_TEXT)) {

                TextTypeArticleViewHolder textViewHolder = (TextTypeArticleViewHolder) holder;
                textViewHolder.mTextview.setText(Html.fromHtml(c.getData()));
                }
            }

        else if(mItems.get(position).getClass()== ArticleListItemImage.class){

            ArticleListItemImage image = (ArticleListItemImage) mItems.get(position);

            ImageTypeArticleViewHolder imageViewHolder = (ImageTypeArticleViewHolder) holder;
            Glide.with(App.getInstance()).load(Constants.IMAGE_BASE_URL + image.getImage()).into(imageViewHolder.mImageView);
            }

        else if(mItems.get(position).getClass() == ArticleListItemTitle.class) {

            ArticleListItemTitle title = (ArticleListItemTitle) mItems.get(position);

            TitleHeaderArticleViewHolder titleviewHolder = (TitleHeaderArticleViewHolder) holder;
            titleviewHolder.mTitle.setText(title.getTitle());
            }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    @Override
    public int getItemViewType(int position) {



        if(mItems.get(position).getClass() == Content.class){

            Content c = (Content) mItems.get(position);

            switch(c.getType()){
                case Constants.ARTICLE_TYPE_TEXT : return Constants.ARTICLE_VIEW_TYPE_TEXT;
                case Constants.ARTICLE_TYPE_IMAGE : return Constants.ARTICLE_VIEW_TYPE_IMAGE;
            }
        }
        else if(mItems.get(position).getClass()== ArticleListItemImage.class){
            return Constants.ARTICLE_VIEW_TYPE_IMAGE;
        }
        else if(mItems.get(position).getClass() == ArticleListItemTitle.class) {
            return Constants.ARTICLE_VIEW_TYPE_TITLE;
        }

        return -1;
    }

     class ImageTypeArticleViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.imageView_item_article)ImageView mImageView;

        public ImageTypeArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class TextTypeArticleViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textView_item_article)TextView mTextview;

        public TextTypeArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    class TitleHeaderArticleViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.article_title_textView) TextView mTitle;

        public TitleHeaderArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    class EmptyViewHolder extends RecyclerView.ViewHolder{

        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}


