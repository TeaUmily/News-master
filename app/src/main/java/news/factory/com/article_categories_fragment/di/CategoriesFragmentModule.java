package news.factory.com.article_categories_fragment.di;


import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import news.factory.com.article_categories_fragment.CategoriesContract;
import news.factory.com.article_categories_fragment.CategoriesFragment;
import news.factory.com.article_categories_fragment.CategoriesPresenter;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.article_categories.CategoriesPagerAdapter;
import news.factory.com.base.base_recycler.view_holders.article_categories.CategoriesPagerAdapterImpl;
import news.factory.com.interaction.categories_interactor.CategoriesInteractor;
import news.factory.com.interaction.categories_interactor.CategoriesInteractorImpl;
import news.factory.com.scopes.PerFragment;

@Module
public class CategoriesFragmentModule {

    @PerFragment
    @Provides
    RecyclerAdapter provideRecyclerAdapter(RecyclerAdapterImpl adapter){
        return adapter;
    }

    @PerFragment
    @Provides
    RecyclerAdapterImpl provideRecyclerAdapterImpl(CategoriesPresenter presenter){
        return new RecyclerAdapterImpl(presenter);
    }

    @PerFragment
    @Provides
    CategoriesInteractor provideCategoriesInteractor(CategoriesInteractorImpl interactor, CategoriesFragment categoriesFragment){
        categoriesFragment.getLifecycle().addObserver(interactor);
        return interactor;
    }

    @PerFragment
    @Provides
    CategoriesContract.View provideCategoriesFragmentView(CategoriesFragment fragment){
        return fragment;
    }


    @PerFragment
    @Provides
    CategoriesContract.Presenter provideCategoriesPresenter(CategoriesPresenter categoriesPresenter)
    {
        return categoriesPresenter;
    }


    @PerFragment
    @Provides
    CategoriesPagerAdapterImpl provideCategoriesPagerAdapterImpl(FragmentManager manager){
        return new CategoriesPagerAdapterImpl(manager);
    }


    @PerFragment
    @Provides
    CategoriesPagerAdapter provideCategoriesPager(FragmentManager manager){
        return new CategoriesPagerAdapterImpl(manager);

    }

    @PerFragment
    @Provides
    FragmentManager provideFragmentManager(CategoriesFragment fragment){
        return fragment.getChildFragmentManager();
    }


}
