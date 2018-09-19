package news.factory.com.article_categories_fragment;

import android.arch.lifecycle.LifecycleObserver;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import news.factory.com.article_fragment.ArticleContract;
import news.factory.com.base_interactor.InteractorWrapper;
import news.factory.com.base_recycler.RecyclerWrapper;
import news.factory.com.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.constants.Constants;
import news.factory.com.helpers.listeners.NetworkResponseListener;
import news.factory.com.helpers.resources_provider.ResourcesProviderImpl;
import news.factory.com.interaction.article_interactor.ArticleInteractor;
import news.factory.com.interaction.categories_interactor.CategoriesInteractor;
import news.factory.com.model.Article;

public class CategoriesPresenter implements CategoriesContract.Presenter, NetworkResponseListener, LifecycleObserver {


    private CategoriesInteractor interactor;
    private CategoriesContract.View categoriesFragmetnView;
    private ResourcesProviderImpl context;

    private Lazy<RecyclerAdapter> recyclerAdapterlazy;

    @Inject
    public CategoriesPresenter(CategoriesContract.View categoriesFragmetnView, CategoriesInteractor interactor, ResourcesProviderImpl context, Lazy<RecyclerAdapter> adapterLazy) {
        this.categoriesFragmetnView = categoriesFragmetnView;
        this.interactor = interactor;
        this.context = context;
        this.recyclerAdapterlazy = adapterLazy;
    }


    @Override
    public void onSuccess(InteractorWrapper callback) {
        Article article = (Article) callback.getData();
        recyclerAdapterlazy.get().addItems(getArticleMappedList(article));
    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    private List<RecyclerWrapper> getArticleMappedList(Article article) {
        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();
        return recyclerWrappers;
    }

    @Override
    public void getArticles() {
        interactor.getArticles(this, Constants.TOKEN, Constants.PAGE_NUMBER, Constants.CATEGORY_ID, Constants.CATEGORY_MOST_POPULAR );

    }

}