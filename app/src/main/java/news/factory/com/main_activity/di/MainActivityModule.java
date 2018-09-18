package news.factory.com.main_activity.di;


import android.support.v4.app.FragmentManager;


import dagger.Module;
import dagger.Provides;

import news.factory.com.interaction.ArticleInteractor;
import news.factory.com.interaction.ArticleInteractorImpl;
import news.factory.com.main_activity.adapter.ViewPagerAdapter;
import news.factory.com.main_activity.contract.MainActivityContract;
import news.factory.com.main_activity.presenter.MainActivityPresenter;
import news.factory.com.main_activity.view.MainActivity;
import news.factory.com.scopes.PerActivity;


@Module
public class MainActivityModule {

    @PerActivity
    @Provides
    ViewPagerAdapter provideAdapter(FragmentManager fragmentManager){
        return new ViewPagerAdapter(fragmentManager);
    }

    @PerActivity
    @Provides
    ArticleInteractor provideArticleInteractor(ArticleInteractorImpl interactor, MainActivity mainActivity){
        mainActivity.getLifecycle().addObserver(interactor);
        return interactor;
    }


    @PerActivity
    @Provides
    FragmentManager provideFragmentManager(MainActivity activity){
        return activity.getSupportFragmentManager();
    }

    @PerActivity
    @Provides
    MainActivityContract.View provideMainActivityView (MainActivity mainActivity){
        return mainActivity;
    }


    @PerActivity
    @Provides
    MainActivityContract.Presenter provideMainActivityPresenter (MainActivityPresenter mainActivityPresenter) {
        return mainActivityPresenter;
    }

}