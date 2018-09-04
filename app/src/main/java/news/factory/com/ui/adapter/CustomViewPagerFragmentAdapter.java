package news.factory.com.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import news.factory.com.model.Article;
import news.factory.com.ui.articleDisplay.ArticleFragment;

public class CustomViewPagerFragmentAdapter extends FragmentPagerAdapter {


    private final ArrayList<Article> ArticleList = new ArrayList<>();

    public CustomViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ArticleFragment.newInstance();
    }

    public void setAdapterData(List<Article> dataSource) {
        this.ArticleList.clear();
        this.ArticleList.addAll(dataSource);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return ArticleList.size();
    }
}


