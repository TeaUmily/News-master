package news.factory.com.home_activity.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import javax.inject.Inject;

import news.factory.com.home_page_fragment.HomePageFragment;


public class HomePagerAdapterImpl extends FragmentStatePagerAdapter  implements HomePagerAdapter {

    private int size;

    @Inject
    public HomePagerAdapterImpl(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return HomePageFragment.newInstance();
    }

    @Override
    public int getCount() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }
}
