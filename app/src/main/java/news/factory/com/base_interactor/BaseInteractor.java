package news.factory.com.base_interactor;


import io.reactivex.observers.DisposableObserver;
import news.factory.com.networking.NetworkResponseListener;


public interface BaseInteractor<T> {

    DisposableObserver<T> provideDisposableObserver(NetworkResponseListener listener);

    void dispose();

}
