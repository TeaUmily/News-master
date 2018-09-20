package news.factory.com.base.base_recycler.view_holders.article_image;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import news.factory.com.R;
import news.factory.com.article_fragment.ArticleContract;
import news.factory.com.article_fragment.ArticlePresenter;
import news.factory.com.base.base_recycler.RecyclerWrapper;

public class ArticleImageHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageView_item_article)ImageView image;

    private List<RecyclerWrapper> dataList;
    private Object object;


    public ArticleImageHolder(View itemView, List<RecyclerWrapper> dataArray, Object object) {
        super(itemView);
        this.object = object;
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
        ArticleContract.Presenter presenter;

        if(object instanceof ArticlePresenter){

            presenter = (ArticlePresenter) object;
            presenter.getArticle(presenter.getArticlePageNumber());
        }


    }

}
