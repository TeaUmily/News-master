package news.factory.com.base_interactor;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import io.reactivex.observers.DisposableObserver;
import news.factory.com.helpers.listeners.NetworkResponseListener;


public class BaseInteractor implements LifecycleObserver{

    DisposableObserver<InteractorWrapper> disposableObserver;


    public DisposableObserver<InteractorWrapper> provideDisposableObserver(final NetworkResponseListener listener) {
        disposableObserver = new DisposableObserver<InteractorWrapper>() {

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
        return  disposableObserver;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void dispose(){
        disposableObserver.dispose();
    }

}
