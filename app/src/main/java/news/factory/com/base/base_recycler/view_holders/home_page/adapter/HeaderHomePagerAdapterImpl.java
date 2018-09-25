package news.factory.com.base.base_recycler.view_holders.home_page.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import javax.inject.Inject;

import news.factory.com.header_fragment.HeaderFragment;

public class HeaderHomePagerAdapterImpl extends FragmentStatePagerAdapter implements HeaderHomePageAdapter{

    private int size;

    @Inject
    public HeaderHomePagerAdapterImpl(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return HeaderFragment.newInstance();
    }

    @Override
    public int getCount() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }
}
