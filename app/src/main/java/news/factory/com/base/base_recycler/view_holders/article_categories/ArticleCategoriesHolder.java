package news.factory.com.base.base_recycler.view_holders.article_categories;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import news.factory.com.R;
import news.factory.com.constants.Constants;

public class ArticleCategoriesHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.articleCategories_viewPager)
    ViewPager viewPager;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    protected CategoriesPagerAdapterImpl adapter;

    public ArticleCategoriesHolder(View itemView, CategoriesPagerAdapterImpl adapter) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.adapter = adapter;
        adapter.setSize(Constants.NUMBER_OF_CATEGORIES);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

//        tabLayout.newTab().setText(Constants.MOST_POPULAR);
//        tabLayout.newTab().setText(Constants.MOST_READ);
//        tabLayout.newTab().setText(Constants.NEWEST);

    }

    public void onBind(int position) {

    }

    public ArticleCategoriesHolder(View itemView) {
        super(itemView);
    }
}
