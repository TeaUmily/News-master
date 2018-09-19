package news.factory.com.base_recycler.view_holders.article_categories;


import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.constants.Constants;

public class ArticleCategoriesHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.articleCategories_viewPager)
    ViewPager viewPager;

    @BindView(R.id.pager_header)
    PagerTabStrip pagerTabStrip;

    protected PagerCategoriesAdapter adapter;

    public ArticleCategoriesHolder(View itemView, AppCompatActivity context) {
        super(itemView);

        adapter = new PagerCategoriesAdapter(context.getSupportFragmentManager());
        ButterKnife.bind(this, itemView);
        adapter.setSize(Constants.NUMBER_OF_CATEGORIES);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }

    public void onBind(int position) {

    }
}

