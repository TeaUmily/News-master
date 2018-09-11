package news.factory.com.base_recycler.recycler.view_holders.article_featured_image;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.App;
import news.factory.com.R;
import news.factory.com.base_recycler.recycler.RecyclerWrapper;
import news.factory.com.constants.Constants;

public class ArticleFeaturedImageHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.featured_image)
    ImageView image;

    @BindView(R.id.category_textView)
    TextView category;

    @BindView(R.id.source_textView)
    TextView source;

    @BindView(R.id.caption_textView)
    TextView caption;

    private List<RecyclerWrapper> dataList;

    public ArticleFeaturedImageHolder(View itemView, List<RecyclerWrapper> dataArray) {

        super(itemView);
        this.dataList = dataArray;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position) {
        if (position != RecyclerView.NO_POSITION) {
            ArticleFeaturedImageData data = (ArticleFeaturedImageData) dataList.get(position).getData();

            if(!data.getImage().isEmpty()){
                Glide.with(App.getInstance()).load(Constants.IMAGE_BASE_URL + data.getImage()).into(image);
            }
            else{
                source.setTextColor(App.getInstance().getResources().getColor(R.color.black));
                caption.setTextColor(App.getInstance().getResources().getColor(R.color.black));
            }

            category.setText(data.getCategory());

            if(!data.getSource().isEmpty()){
                source.setText(App.getInstance().getResources().getString(R.string.source,data.getSource()));
            }
            else{
                source.setVisibility(View.GONE);
            }

            if(!data.getCaption().isEmpty()){
                caption.setText(data.getCaption());
            }
            else {
                caption.setVisibility(View.GONE);
            }

        }
    }
}
