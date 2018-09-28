package news.factory.com.base.base_recycler.view_holders.article_categories;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import javax.inject.Inject;

import news.factory.com.single_screen.article_categories_fragment.CategoriesFragment;
import news.factory.com.constants.Constants;

public class CategoriesPagerAdapterImpl extends FragmentStatePagerAdapter implements CategoriesPagerAdapter{


    private int size;

    @Inject
    public CategoriesPagerAdapterImpl(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return CategoriesFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return Constants.MOST_POPULAR;
        }
        if(position == 1){
            return  Constants.MOST_READ;
        }
        if(position == 2){
            return  Constants.NEWEST;
        }
        return "";
    }
}
