package news.factory.com.base.base_recycler.view_holders.home_page.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.List;

import javax.inject.Inject;

import news.factory.com.home_screen.header_fragment.HeaderFragment;
import news.factory.com.model.Articles;

public class HeaderHomePagerAdapterImpl extends FragmentStatePagerAdapter implements HeaderHomePageAdapter{

    private int size;
    private List<Articles> dataList;

    @Inject
    public HeaderHomePagerAdapterImpl(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return HeaderFragment.newInstance(position , dataList);
    }

    @Override
    public int getCount() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }

    public void setDataList(List<Articles> dataList) {
        this.dataList = dataList;
    }


}
