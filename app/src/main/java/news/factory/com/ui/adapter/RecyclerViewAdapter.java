package news.factory.com.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import news.factory.com.constants.Constants;
import news.factory.com.model.Content;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private List<Content> mContents;

    public RecyclerViewAdapter() {
        mContents = new ArrayList<>();
    }

    public void addContents(List<Content> contents){
        mContents.clear();
        mContents.addAll(contents);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == 0){
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_article_text, parent, false);
            return new TextTypeArticleViewHolder(itemView);
        }
        else if (viewType == 1){

            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_article_image, parent, false);
            return new ImageTypeArticleViewHolder(itemView);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final Content current = mContents.get(position);

       if(mContents.get(position).getType().equals(Constants.ARTICLE_TYPE_IMAGE)){
            ImageTypeArticleViewHolder imageViewHolder = (ImageTypeArticleViewHolder) holder;
            Glide.with(App.getInstance()).load(Constants.IMAGE_BASE_URL + current.getImage().getOriginal()).into(imageViewHolder.mImageView);
        }
        else if(mContents.get(position).getType().equals(Constants.ARTICLE_TYPE_TEXT)){
            TextTypeArticleViewHolder textViewHolder = (TextTypeArticleViewHolder) holder;
            textViewHolder.mTextview.setText(current.getData());
       }
    }

    @Override
    public int getItemCount() {
        return mContents.size();
    }


    @Override
    public int getItemViewType(int position) {

        switch (mContents.get(position).getType()) {
            case Constants.ARTICLE_TYPE_TEXT : return 0;
            case Constants.ARTICLE_TYPE_IMAGE : return 1;
            default: return -1;
        }
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

}
