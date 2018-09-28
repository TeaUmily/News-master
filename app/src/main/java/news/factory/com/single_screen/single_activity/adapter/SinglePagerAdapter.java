package news.factory.com.single_screen.single_activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import news.factory.com.single_screen.article_fragment.ArticleFragment;

public class SinglePagerAdapter extends FragmentStatePagerAdapter {


    private int size;

    public SinglePagerAdapter(FragmentManager fm) {
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


