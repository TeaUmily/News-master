package news.factory.com.base_recycler.view_holders.article_image;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import news.factory.com.App;
import news.factory.com.R;
import news.factory.com.article_fragment.contract.ArticleDisplayContract;
import news.factory.com.base_recycler.RecyclerWrapper;
import news.factory.com.base_recycler.view_holders.article_image.ArticleImageData;
import news.factory.com.constants.Constants;
import news.factory.com.helpers.listeners.OnImageClickListener;

public class ArticleImageHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageView_item_article)ImageView image;

    private List<RecyclerWrapper> dataList;
    private OnImageClickListener listener;


    public ArticleImageHolder(View itemView, List<RecyclerWrapper> dataArray, ArticleDisplayContract.Presenter presenter) {
        super(itemView);
        this.listener = (OnImageClickListener) presenter;
        this.dataList = dataArray;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleImageData data = (ArticleImageData) dataList.get(position).getData();
            Glide.with(image.getContext()).load(data.getImage()).into(image);
        }
    }

    @OnClick(R.id.imageView_item_article)
    public void onImageClick(){
        listener.onImageClick();
        Log.wtf("tEreZijaaaa", "desilo see");
    }




}
