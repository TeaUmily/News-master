package news.factory.com.home_screen.category_inner_fragment;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import dagger.Lazy;
import news.factory.com.R;
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

public class CategoryInnerPresenter implements CategoryInnerContract.Presenter, NetworkResponseListener {

    private CategoriesInteractor interactor;
    private CategoryInnerContract.View  categoryInnerView;

    private Lazy<RecyclerAdapter> recyclerAdapterLazy;

    private ResourcesProviderImpl context;

    @Inject
    public CategoryInnerPresenter(CategoryInnerContract.View  categoryInnerView, ResourcesProviderImpl context, CategoriesInteractor interactor, Lazy<RecyclerAdapter> adapterLazy) {
        this.categoryInnerView= categoryInnerView;
        this.interactor = interactor;
        this.recyclerAdapterLazy = adapterLazy;
        this.context = context;
    }

    @Override
    public void getNewestArticles(int mainPosition) {
        switch(mainPosition){

            case 1:  interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, "0" , Constants.CATEGORY_NEWEST);
            break;

            case 2: interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, "1" , Constants.CATEGORY_NEWEST);
            break;

            case 3: interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, "2" , Constants.CATEGORY_NEWEST);
            break;
        }
    }

    @Override
    public void getMostReadArticles(int mainPosition) {

        switch(mainPosition){

            case 1:  interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, "0" , Constants.CATEGORY_MOST_READ);
                break;

            case 2: interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, "1" , Constants.CATEGORY_MOST_READ);
                break;

            case 3: interactor.getArticles(this, Constants.TOKEN, Constants.CATEGORIES_PAGE_NUMBER, "2" , Constants.CATEGORY_MOST_READ);
                break;
        }
    }

    @Override
    public void openArticle(String articleId) {
        categoryInnerView.showArticle(articleId);
    }


    @Override
    public void onSuccess(InteractorWrapper callback) {
        Category category = (Category) callback.getData();
        recyclerAdapterLazy.get().addItems(getArticleMappedList(category));

    }

    private List<RecyclerWrapper> getArticleMappedList(Category category) {

        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();

        for(int i=0; i<4 ; i++) {
            Articles articles = category.getArticles().get(i);

            String publishedTime;
            if(getPastDays(articles.getPublishedAtHumans()).endsWith("1")){
                publishedTime = context.provideString(R.string.publishedTime, getPastDays(articles.getPublishedAtHumans()));
            }
            else{
                publishedTime = context.provideString(R.string.publishedTimeEndsWithA, getPastDays(articles.getPublishedAtHumans()));
            }

            recyclerWrappers.add(new RecyclerWrapper(new ArticleItemData(articles.getFeaturedImage().getM(), articles.getTitle(), publishedTime, articles.getCategory(), articles.getShares(), articles.getId()), RecyclerWrapper.TYPE_ARTIClE_ITEM));
        }

        return recyclerWrappers;
    }

    public String getPastDays(String publishedAtHumans){

        String publishedAt = publishedAtHumans.replace(".", "/");

        String pattern = "dd/MM/yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            Date date = simpleDateFormat.parse(publishedAt);
            return String.valueOf(getDifferenceBetweenDates(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public int getDifferenceBetweenDates(Date publicationDate){

        return (int)((new Date().getTime()- publicationDate.getTime())/(1000 * 60 * 60 * 24));
    }


    @Override
    public void onFailure(Throwable throwable) {

    }


}
