package news.factory.com.interaction.article_interaction;


import android.arch.lifecycle.LifecycleObserver;


import javax.inject.Inject;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import news.factory.com.base.base_interactor.BaseInteractor;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.model.Article;
import news.factory.com.networking.ApiService;
import news.factory.com.helpers.listeners.NetworkResponseListener;


public class ArticleInteractorImpl extends BaseInteractor implements ArticleInteractor{

    ApiService service;

    @Inject
    public ArticleInteractorImpl(ApiService service) {
        this.service = service;
    }

    @Override
    public void  getArticle(final NetworkResponseListener listener, String token, String pageNumber, String categoryId, String categoryType) {

        service.getArticle(categoryType, categoryId, token, pageNumber).subscribeOn(Schedulers.io())
                .map(new Function<Article, InteractorWrapper>() {
                    @Override
                    public InteractorWrapper apply(Article article) throws Exception {
                        InteractorWrapper data = new InteractorWrapper(article);
                        return data;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(provideDisposableObserver(listener));
    }


}
