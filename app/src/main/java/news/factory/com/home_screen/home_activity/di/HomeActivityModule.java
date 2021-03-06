package news.factory.com.home_screen.home_activity.di;


import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import news.factory.com.home_screen.home_activity.HomeActivity;
import news.factory.com.home_screen.home_activity.HomeActivityContract;
import news.factory.com.home_screen.home_activity.HomeActivityPresenter;
import news.factory.com.home_screen.home_activity.adapter.HomePagerAdapterImpl;
import news.factory.com.interaction.home_screen_interactor.HomeScreenInteractor;
import news.factory.com.interaction.home_screen_interactor.HomeScreenInteractorImpl;
import news.factory.com.scopes.PerActivity;

@Module
public class HomeActivityModule {


    @PerActivity
    @Provides
    HomePagerAdapterImpl provideAdapter(FragmentManager fragmentManager){
        return new HomePagerAdapterImpl(fragmentManager);
    }

    @PerActivity
    @Provides
    FragmentManager provideFragmentManager(HomeActivity activity){
        return activity.getSupportFragmentManager();
    }

    @PerActivity
    @Provides
    HomeActivityContract.View provideHomeActivity (HomeActivity activity){
        return activity;
    }

    @PerActivity
    @Provides
    HomeActivityContract.Presenter provideHomeActivityPresenter(HomeActivityPresenter presenter){
        return presenter;
    }

    @PerActivity
    @Provides
    HomeScreenInteractor provideHomeScreenInteractor (HomeScreenInteractorImpl interactor, HomeActivity activity){
       // activity.getLifecycle().addObserver(interactor);
        return interactor;
    }

}
