package news.factory.com.base.base_recycler.view_holders.home_page;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePagerAdapterImpl;

public class HomePageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.home_page_header_viewpager)
    ViewPager viewPager;

    @BindView(R.id.tablayout_header)
    TabLayout tabLayout;

    private HeaderHomePagerAdapterImpl adapter;

    public HomePageViewHolder(View itemView, HeaderHomePagerAdapterImpl adapter) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.adapter = adapter;
        adapter.setSize(5);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    public void onBind(int position) {

    }
}
