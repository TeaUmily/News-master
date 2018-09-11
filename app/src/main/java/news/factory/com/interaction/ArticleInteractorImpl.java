package news.factory.com.interaction;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import news.factory.com.baseInteractor.BaseInteractor;
import news.factory.com.model.Article;
import news.factory.com.networking.ApiService;
import news.factory.com.networking.NetworkResponseListener;


public class ArticleInteractorImpl extends BaseInteractor<Article> implements ArticleInteractor{

    ApiService service;

    public ArticleInteractorImpl(NetworkResponseListener listener, ApiService service) {
        super(listener);
        this.service = service;
    }

    @Override
    public void  getArticle(final NetworkResponseListener listener, String Token, String PageNumber, String ArticleId, String ArticleType) {
        service.getArticle(ArticleType, ArticleId, Token, PageNumber).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getDisposableObserver());
    }

    @Override
    public DisposableObserver getObserver() {
        return getDisposableObserver();
    }


}
