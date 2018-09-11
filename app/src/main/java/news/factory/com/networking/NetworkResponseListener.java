package news.factory.com.networking;

import news.factory.com.baseInteractor.InteractorWrapper;

public interface NetworkResponseListener {

    void onSuccess(InteractorWrapper callback);
    void onFailure(Throwable throwable);

}
