package news.factory.com.interaction;


import io.reactivex.observers.DisposableObserver;
import news.factory.com.networking.NetworkResponseListener;


public interface BaseInteractor<T> {

    DisposableObserver<T> provideDisposableObserver(NetworkResponseListener listener);

    void dispose();

}
