package news.factory.com.home_screen.home_page_fragment.di;


import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePageAdapter;
import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePagerAdapterImpl;
import news.factory.com.home_screen.home_page_fragment.HomePageFragment;
import news.factory.com.home_screen.home_page_fragment.HomePageFragmentContract;
import news.factory.com.home_screen.home_page_fragment.HomePageFragmentPresenter;
import news.factory.com.interaction.home_screen_interactor.HomeScreenInteractor;
import news.factory.com.interaction.home_screen_interactor.HomeScreenInteractorImpl;
import news.factory.com.scopes.PerFragment;

@Module
public class HomePageFragmentModule {


    @PerFragment
    @Provides
    RecyclerAdapter provideRecyclerAdapter(RecyclerAdapterImpl adapter){
        return adapter;
    }


    @PerFragment
    @Provides
    RecyclerAdapterImpl provideRecyclerAdapterImpl(HomePageFragmentPresenter presenter){
        return new RecyclerAdapterImpl(presenter);
    }

    @PerFragment
    @Provides
    HomePageFragmentContract.View provideHomeFragmentView(HomePageFragment fragment) {
        return fragment;
    }

    @PerFragment
    @Provides
    HomePageFragmentContract.Presenter provideHomePagePresenter (HomePageFragmentPresenter presenter){
        return presenter;
    }

    @PerFragment
    @Provides
    HomeScreenInteractor provideHomeScreenInteractor(HomeScreenInteractorImpl interactor, HomePageFragment fragment ){
        fragment.getLifecycle().addObserver(interactor);
        return interactor;
    }

    @PerFragment
    @Provides
    FragmentManager provideFragmentManager(HomePageFragment fragment){
        return fragment.getChildFragmentManager();
    }

    @PerFragment
    @Provides
    HeaderHomePageAdapter provideHeaderPagerAdapter(FragmentManager manager){
        return new HeaderHomePagerAdapterImpl(manager);

    }


}
