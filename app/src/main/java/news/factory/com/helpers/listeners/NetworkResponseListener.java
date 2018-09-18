package news.factory.com.helpers.listeners;

import news.factory.com.base_interactor.InteractorWrapper;

public interface NetworkResponseListener {

    void onSuccess(InteractorWrapper callback);
    void onFailure(Throwable throwable);

}
