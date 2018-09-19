package news.factory.com.main_activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import javax.inject.Inject;

import news.factory.com.article_fragment.ArticleFragment;

public class PagerMainAdapter extends FragmentPagerAdapter {


    private int size;

    @Inject
    public PagerMainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ArticleFragment.newInstance(position);
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getCount() {
        return size;
    }
}


