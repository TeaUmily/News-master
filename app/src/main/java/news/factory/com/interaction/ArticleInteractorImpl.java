package news.factory.com.interaction;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import news.factory.com.model.Article;
import news.factory.com.networking.ApiService;
import news.factory.com.networking.NetworkResponseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleInteractorImpl implements ArticleInteractor {

    private final ApiService apiService;

    public ArticleInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getArticle(final NetworkResponseListener<Article> listener, String Token, String PageNumber, String ArticleId, String ArticleType) {
        apiService.getArticle(ArticleType, ArticleId, Token, PageNumber).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Article>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Article article) {
                listener.onSuccess(article);
            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
            }

            @Override
            public void onComplete() {

            }
        });

    }

}

