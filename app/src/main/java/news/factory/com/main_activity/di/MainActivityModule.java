package news.factory.com.main_activity.di;

import android.support.v4.app.FragmentManager;


import com.maradroid.dummyresponsegenerator.base.interactor.Interactor;

import butterknife.BindString;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import io.reactivex.observers.DisposableObserver;
import news.factory.com.article_fragment.view.ArticleFragment;
import news.factory.com.base_interactor.InteractorWrapper;
import news.factory.com.interaction.ArticleInteractor;
import news.factory.com.interaction.ArticleInteractorImpl;
import news.factory.com.main_activity.adapter.ViewPagerAdapter;
import news.factory.com.main_activity.contract.MainActivityContract;
import news.factory.com.main_activity.presenter.MainActivityPresenter;
import news.factory.com.main_activity.view.MainActivity;
import news.factory.com.networking.ApiService;
import news.factory.com.networking.NetworkResponseListener;

@Module
public class MainActivityModule {

    @Provides
    ViewPagerAdapter provideAdapter(FragmentManager fragmentManager){
        return new ViewPagerAdapter(fragmentManager);
    }

    @Provides
    FragmentManager provideFragmentManager(MainActivity activity){
        return activity.getSupportFragmentManager();
    }

    @Provides
    MainActivityContract.View provideMainActivityView (){
        return new MainActivity();
    }

    @Provides
    MainActivityContract.Presenter provideMainActivityPresenter (MainActivity mainActivity, ArticleInteractor interactor)
    {
        return new MainActivityPresenter(mainActivity, interactor);
    }


}