package news.factory.com.home_screen.category_external_fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import javax.inject.Inject;

import news.factory.com.home_screen.category_inner_fragment.CategoryInnerFragment;
import news.factory.com.constants.Constants;

public class CategoriesPagerAdapter extends FragmentStatePagerAdapter {

    private int size;
    private int mainPagerPosition;

    @Inject
    public CategoriesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryInnerFragment.newInstance(position, mainPagerPosition);
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
        if(position == 0){
            return Constants.NEWEST;
        }
        else{
            return Constants.MOST_READ;
        }
    }

    public void setMainPagerPosition(int mainPagerPosition) {
        this.mainPagerPosition = mainPagerPosition;
    }
}
