package news.factory.com.interaction.categories_interactor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import news.factory.com.base_interactor.BaseInteractor;


import news.factory.com.base_interactor.InteractorWrapper;
import news.factory.com.helpers.listeners.NetworkResponseListener;
import news.factory.com.model.Category;
import news.factory.com.networking.ApiService;

public class CategoriesInteractorImpl extends BaseInteractor implements CategoriesInteractor{

    ApiService service;

    @Inject
    public CategoriesInteractorImpl(ApiService service) {
        this.service = service;
    }

    @Override
    public void  getArticles(final NetworkResponseListener listener, String Token, String PageNumber, String ArticleId, String ArticleType) {

        service.getArticles(ArticleType, ArticleId, Token, PageNumber).subscribeOn(Schedulers.io())
                .map(new Function <Category, InteractorWrapper>() {
                    @Override
                    public InteractorWrapper apply(Category categories) throws Exception {
                        InteractorWrapper data = new InteractorWrapper(categories);
                        return data;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(provideDisposableObserver(listener));
    }











}
