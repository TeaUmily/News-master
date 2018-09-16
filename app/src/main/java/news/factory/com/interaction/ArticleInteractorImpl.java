package news.factory.com.interaction;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import news.factory.com.base_interactor.InteractorWrapper;
import news.factory.com.model.Article;
import news.factory.com.networking.ApiService;
import news.factory.com.networking.NetworkResponseListener;


public class ArticleInteractorImpl implements ArticleInteractor{

    ApiService service;
    DisposableObserver<InteractorWrapper> disposableObserver;

    public ArticleInteractorImpl(ApiService service) {
        this.service = service;
    }

    @Override
    public void  getArticle(final NetworkResponseListener listener, String Token, String PageNumber, String ArticleId, String ArticleType) {
       disposableObserver = provideDisposableObserver(listener);
        service.getArticle(ArticleType, ArticleId, Token, PageNumber).subscribeOn(Schedulers.io())
                .map(new Function<Article, InteractorWrapper>() {
                    @Override
                    public InteractorWrapper apply(Article article) throws Exception {
                        InteractorWrapper data = new InteractorWrapper(article);
                        return data;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver);
    }


    public DisposableObserver<InteractorWrapper> provideDisposableObserver(final NetworkResponseListener listener) {
        return  new DisposableObserver<InteractorWrapper>() {

            @Override
            public void onNext(InteractorWrapper data) {
                listener.onSuccess(data);
            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
            }

            @Override
            public void onComplete() {

            }
        };
    }


    @Override
    public void dispose() {
        disposableObserver.dispose();
    }
}
