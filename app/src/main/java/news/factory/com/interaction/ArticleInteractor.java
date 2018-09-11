package news.factory.com.interaction;

import io.reactivex.observers.DisposableObserver;
import news.factory.com.model.Article;
import news.factory.com.networking.NetworkResponseListener;

public interface ArticleInteractor {

    void getArticle(NetworkResponseListener listener, String Token, String PageNumber, String ArticleId, String ArticleType);

    DisposableObserver getObserver();

}
