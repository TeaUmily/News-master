package news.factory.com.article_categories_fragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.base.base_recycler.view_holders.article_item.ArticleItemData;
import news.factory.com.constants.Constants;
import news.factory.com.helpers.listeners.NetworkResponseListener;
import news.factory.com.helpers.resources_provider.ResourcesProviderImpl;
import news.factory.com.interaction.categories_interactor.CategoriesInteractor;
import news.factory.com.model.Articles;
import news.factory.com.model.Category;

public class CategoriesPresenter implements CategoriesContract.Presenter, NetworkResponseListener {


    private CategoriesInteractor interactor;
    private CategoriesContract.View categoriesFragmentView;
    private Lazy<RecyclerAdapter> recyclerAdapterlazy;

    @Inject
    public CategoriesPresenter(CategoriesContract.View categoriesFragmentView, CategoriesInteractor interactor, ResourcesProviderImpl context, Lazy<RecyclerAdapter> adapterLazy) {
        this.categoriesFragmentView = categoriesFragmentView;
        this.interactor = interactor;
        this.recyclerAdapterlazy = adapterLazy;
    }

    public void getArticles(int pageNum) {

        switch (pageNum){
            case 0: interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, Constants.CATEGORY_ID, Constants.CATEGORY_MOST_POPULAR);
            break;
            case 1:  interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, Constants.CATEGORY_ID, Constants.CATEGORY_MOST_READ);
            break;
            case 2:  interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, Constants.CATEGORY_ID, Constants.CATEGORY_NEWEST);
            break;
        }
    }

    @Override
    public void onSuccess(InteractorWrapper callback) {
        Category category = (Category) callback.getData();
        recyclerAdapterlazy.get().addItems(getArticleMappedList(category));
    }

    private List<RecyclerWrapper> getArticleMappedList(Category category) {

        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();

       for(int i=0; i<4 ; i++) {
           Articles articles = category.getArticles().get(i);
           recyclerWrappers.add(new RecyclerWrapper(new ArticleItemData(articles.getFeaturedImage().getS(), articles.getTitle(), articles.getPublishedAtHumans(), articles.getCategory(), articles.getShares()), RecyclerWrapper.TYPE_ARTIClE_ITEM));
       }

        return recyclerWrappers;
    }


    @Override
    public void onFailure(Throwable throwable){
    }
}
