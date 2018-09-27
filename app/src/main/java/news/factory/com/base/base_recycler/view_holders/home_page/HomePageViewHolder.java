package news.factory.com.base.base_recycler.view_holders.home_page;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import butterknife.OnPageChange;
import news.factory.com.R;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.view_holders.home_news_categories.NewsCategoriesData;
import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePagerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.home_page_categories.HomePageCategoryNameData;
import news.factory.com.model.Image;

public class HomePageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.home_page_header_viewpager)
    ViewPager viewPager;

    @BindView(R.id.tablayout_header)
    TabLayout tabLayout;

    @BindView(R.id.title_header_home_page)
    TextView title;

    private HeaderHomePagerAdapterImpl adapter;
    private List<RecyclerWrapper> dataList;
    private HomePageHeaderData data;

    public HomePageViewHolder(View itemView, HeaderHomePagerAdapterImpl adapter, List<RecyclerWrapper> list) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.dataList = list;
        this.adapter = adapter;

    }

    public void onBind(int position) {

        if (position != RecyclerView.NO_POSITION) {

            data = (HomePageHeaderData) dataList.get(position).getData();
            adapter.setSize(data.getArticles().size());
            adapter.setDataList(data.getArticles());
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);

            int index = viewPager.getCurrentItem();
            title.setText(data.getArticles().get(index).getTitle());
        }

    }

    @OnPageChange(R.id.home_page_header_viewpager)
    public void onArticleSelected(){
        int position = viewPager.getCurrentItem();
        title.setText(data.getArticles().get(position).getTitle());
    }
}
