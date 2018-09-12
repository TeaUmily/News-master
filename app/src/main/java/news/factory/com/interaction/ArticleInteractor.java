package news.factory.com.interaction;

import io.reactivex.observers.DisposableObserver;
import news.factory.com.base_interactor.InteractorWrapper;
import news.factory.com.networking.NetworkResponseListener;

public interface ArticleInteractor extends BaseInteractor<InteractorWrapper> {

    void getArticle(NetworkResponseListener listener, String Token, String PageNumber, String ArticleId, String ArticleType);

    DisposableObserver getObserver();

}
