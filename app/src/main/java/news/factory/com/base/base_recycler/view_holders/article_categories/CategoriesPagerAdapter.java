package news.factory.com.base.base_recycler.view_holders.article_categories;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import news.factory.com.article_categories_fragment.CategoriesFragment;

public class CategoriesPagerAdapter extends FragmentStatePagerAdapter{


    private int size;

    public CategoriesPagerAdapter(FragmentManager fm) {
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
            return  "Najpopularnije";
        }
        if(position == 1){
            return  "Najčitanije";
        }
        if(position == 2){
            return  "Najnovije";
        }
        return "";
    }
}
