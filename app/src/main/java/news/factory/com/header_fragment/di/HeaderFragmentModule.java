package news.factory.com.header_fragment.di;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePageAdapter;
import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePagerAdapterImpl;
import news.factory.com.header_fragment.HeaderContract;
import news.factory.com.header_fragment.HeaderFragment;
import news.factory.com.scopes.PerFragment;

@Module
public class HeaderFragmentModule {



    @PerFragment
    @Provides
    HeaderContract.View provideHeaderFragmentView(HeaderFragment fragment){
        return fragment;
    }


//    @PerFragment
//    @Provides
//    HeaderContract.Presenter provideHeaderPresenter(HeaderPresenter presenter)
//    {
//        return presenter;
//    }
//

    @PerFragment
    @Provides
    HeaderHomePagerAdapterImpl provideHeaderPagerAdapterImpl(FragmentManager manager){
        return new HeaderHomePagerAdapterImpl(manager);
    }


    @PerFragment
    @Provides
    HeaderHomePageAdapter provideHeaderPagerAdapter(FragmentManager manager){
        return new HeaderHomePagerAdapterImpl(manager);

    }

    @PerFragment
    @Provides
    FragmentManager provideFragmentManager(HeaderFragment fragment){
        return fragment.getChildFragmentManager();
    }



}
