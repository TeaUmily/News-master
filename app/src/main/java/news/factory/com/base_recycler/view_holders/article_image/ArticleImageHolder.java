package news.factory.com.base_recycler.recycler.view_holders.article_image;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.App;
import news.factory.com.R;
import news.factory.com.base_recycler.RecyclerWrapper;
import news.factory.com.constants.Constants;

public class ArticleImageHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.imageView_item_article)ImageView image;

    private List<RecyclerWrapper> dataList;


    public ArticleImageHolder(View itemView, List<RecyclerWrapper> dataArray) {
        super(itemView);
        this.dataList = dataArray;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleImageData data = (ArticleImageData) dataList.get(position).getData();
            Glide.with(App.getInstance()).load(Constants.IMAGE_BASE_URL + data.getImage()).into(image);
        }
    }
}
