package news.factory.com.article.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import news.factory.com.article.model.Article;
import news.factory.com.article.view.ArticleFragment;

public class CustomViewPagerFragmentAdapter extends FragmentPagerAdapter {



    private int mSize;

    public CustomViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ArticleFragment.newInstance(position);
    }

    public void setSize(int size) {
        this.mSize = size;
    }

    @Override
    public int getCount() {
        return mSize;
    }
}


