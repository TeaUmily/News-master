package news.factory.com.base.base_recycler.view_holders.article_item;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import news.factory.com.R;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.constants.Constants;

public class ArticleItemHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.featured_image_item)
    ImageView image;

    @BindView(R.id.title_item)
    TextView title;

    @BindView(R.id.category_type)
    TextView categoryType;

    @BindView(R.id.number_of_shares)
    TextView numberOfShares;

    @BindView(R.id.publication_time_item)
    TextView publicationTime;

    List<RecyclerWrapper> dataList;

    public ArticleItemHolder(View itemView, List<RecyclerWrapper> list) {
        super(itemView);
        this.dataList = list;

        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleItemData data = (ArticleItemData) dataList.get(position).getData();
            Glide.with(image.getContext()).load(Constants.IMAGE_BASE_URL + data.getFeaturedImage()).into(image);
            title.setText(data.getTitle());
            categoryType.setText(data.getCategory());
            numberOfShares.setText(data.getNumberOfShares());
            publicationTime.setText(data.getPublishedAtHumans());

        }
    }
}