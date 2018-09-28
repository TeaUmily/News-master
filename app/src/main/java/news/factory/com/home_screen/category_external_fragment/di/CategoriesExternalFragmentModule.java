package news.factory.com.home_screen.category_external_fragment.di;



import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import news.factory.com.home_screen.category_external_fragment.CategoriesExternalFragment;
import news.factory.com.home_screen.category_external_fragment.CategoriesPagerAdapter;
import news.factory.com.scopes.PerFragment;

@Module
public class CategoriesExternalFragmentModule {


    @PerFragment
    @Provides
    CategoriesPagerAdapter provideCategoriesPagerAdapter(FragmentManager manager){
        return new CategoriesPagerAdapter(manager);
    }

    @PerFragment
    @Provides
    FragmentManager provideFragmentManager(CategoriesExternalFragment fragment){
        return fragment.getChildFragmentManager();
    }

}
