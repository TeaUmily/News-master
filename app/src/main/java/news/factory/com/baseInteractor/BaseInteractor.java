package news.factory.com.baseInteractor;

import io.reactivex.observers.DisposableObserver;
import news.factory.com.networking.NetworkResponseListener;

public abstract class BaseInteractor<T>{

        private DisposableObserver<T> disposableObserver;
        private NetworkResponseListener mListener;



        public BaseInteractor(final NetworkResponseListener listener) {
            this.mListener = listener;

            disposableObserver = new DisposableObserver<T>() {

                @Override
                public void onNext(T data) {
                    listener.onSuccess(new InteractorWrapper(data));
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


    protected DisposableObserver<T> getDisposableObserver() {
            return disposableObserver;
        }


}



