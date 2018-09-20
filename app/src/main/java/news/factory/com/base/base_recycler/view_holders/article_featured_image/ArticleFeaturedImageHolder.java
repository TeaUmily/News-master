package news.factory.com.base.base_recycler.view_holders.article_featured_image;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_recycler.RecyclerWrapper;
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

            if(data.getImage() != null){
                Glide.with(image.getContext()).load(Constants.IMAGE_BASE_URL + data.getImage()).into(image);
            }
            else{
                source.setTextColor(data.getTextColor());
                caption.setTextColor(data.getTextColor());
            }

            category.setText(data.getCategory());

            if(!data.getSource().isEmpty()){
                source.setText(data.getSource());
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
