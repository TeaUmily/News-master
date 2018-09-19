package news.factory.com.article_categories_fragment.di;



import dagger.Module;
import dagger.Provides;
import news.factory.com.article_categories_fragment.CategoriesContract;
import news.factory.com.article_categories_fragment.CategoriesFragment;
import news.factory.com.article_categories_fragment.CategoriesPresenter;
import news.factory.com.article_fragment.ArticleFragment;
import news.factory.com.article_fragment.ArticlePresenter;
import news.factory.com.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.interaction.article_interactor.ArticleInteractor;
import news.factory.com.interaction.article_interactor.ArticleInteractorImpl;
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


}
