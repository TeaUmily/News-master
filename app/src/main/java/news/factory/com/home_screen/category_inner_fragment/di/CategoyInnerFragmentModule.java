package news.factory.com.home_screen.category_inner_fragment.di;


import dagger.Module;
import dagger.Provides;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.home_screen.category_inner_fragment.CategoryInnerContract;
import news.factory.com.home_screen.category_inner_fragment.CategoryInnerFragment;
import news.factory.com.home_screen.category_inner_fragment.CategoryInnerPresenter;
import news.factory.com.interaction.categories_interactor.CategoriesInteractor;
import news.factory.com.interaction.categories_interactor.CategoriesInteractorImpl;
import news.factory.com.scopes.PerFragment;

@Module
public class CategoyInnerFragmentModule {


    @PerFragment
    @Provides
    CategoryInnerContract.Presenter providePresenter(CategoryInnerPresenter presenter){
        return presenter;
    }

    @PerFragment
    @Provides
    CategoryInnerContract.View provideView(CategoryInnerFragment view){
        return view;
    }


    @PerFragment
    @Provides
    RecyclerAdapter provideRecyclerAdapter(RecyclerAdapterImpl adapter){
        return adapter;
    }

    @PerFragment
    @Provides
    RecyclerAdapterImpl provideRecyclerAdapterImpl(CategoryInnerPresenter presenter){
        return new RecyclerAdapterImpl(presenter);
    }

    @PerFragment
    @Provides
    CategoriesInteractor provideCategoriesInteractor(CategoriesInteractorImpl interactor, CategoryInnerFragment categoriesFragment){
       // categoriesFragment.getLifecycle().addObserver(interactor);
        return interactor;
    }


}
