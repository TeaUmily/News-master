package news.factory.com.main_activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import news.factory.com.article_fragment.view.ArticleFragment;

public class CustomViewPagerFragmentAdapter extends FragmentPagerAdapter {


    private int size;

    public CustomViewPagerFragmentAdapter(FragmentManager fm) {
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


