package news.factory.com.single_activity.di;


import android.support.v4.app.FragmentManager;


import dagger.Module;
import dagger.Provides;

import news.factory.com.interaction.article_interaction.ArticleInteractor;
import news.factory.com.interaction.article_interaction.ArticleInteractorImpl;
import news.factory.com.single_activity.SingleActivity;
import news.factory.com.single_activity.adapter.SinglePagerAdapter;
import news.factory.com.single_activity.SingleActivityContract;
import news.factory.com.single_activity.SingleActivityPresenter;
import news.factory.com.scopes.PerActivity;


@Module
public class SingleActivityModule {

    @PerActivity
    @Provides
    SinglePagerAdapter provideAdapter(FragmentManager fragmentManager){
        return new SinglePagerAdapter(fragmentManager);
    }

    @PerActivity
    @Provides
    ArticleInteractor provideArticleInteractor(ArticleInteractorImpl interactor, SingleActivity mainActivity){
        mainActivity.getLifecycle().addObserver(interactor);
        return interactor;
    }


    @PerActivity
    @Provides
    FragmentManager provideFragmentManager(SingleActivity activity){
        return activity.getSupportFragmentManager();
    }

    @PerActivity
    @Provides
    SingleActivityContract.View provideMainActivityView (SingleActivity mainActivity){
        return mainActivity;
    }


    @PerActivity
    @Provides
    SingleActivityContract.Presenter provideMainActivityPresenter (SingleActivityPresenter mainActivityPresenter) {
        return mainActivityPresenter;
    }

}