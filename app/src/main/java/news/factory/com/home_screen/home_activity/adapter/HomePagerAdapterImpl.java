package news.factory.com.home_screen.home_activity.adapter;



import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import javax.inject.Inject;

import news.factory.com.home_screen.category_external_fragment.CategoriesExternalFragment;
import news.factory.com.home_screen.home_page_fragment.HomePageFragment;
import news.factory.com.model.HomeMenuBottomItem;


public class HomePagerAdapterImpl extends FragmentStatePagerAdapter implements HomePagerAdapter {

    private int size;
    private List<HomeMenuBottomItem> dataList;

    @Inject
    public HomePagerAdapterImpl(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return HomePageFragment.newInstance();
        }
        else{
            return CategoriesExternalFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return dataList.get(position).getTitle();
    }

    public void setDataList(List<HomeMenuBottomItem> dataList) {
        this.dataList = dataList;
    }
}
