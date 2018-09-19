package news.factory.com.base_recycler.view_holders.article_categories;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import javax.inject.Inject;
import news.factory.com.article_categories_fragment.CategoriesFragment;


public class PagerCategoriesAdapter extends FragmentPagerAdapter{

    private int size;

    public PagerCategoriesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return CategoriesFragment.newInstance(position);
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getCount() {
        return size;
    }

    @Nullable
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
