package news.factory.com.networking;

public interface NetworkResponseListener<T> {

    void onSuccess(T callback);
    void onFailure(Throwable throwable);

}
