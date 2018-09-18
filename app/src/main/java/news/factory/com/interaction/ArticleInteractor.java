package news.factory.com.interaction;


import news.factory.com.helpers.listeners.NetworkResponseListener;

public interface ArticleInteractor {

    void getArticle(NetworkResponseListener listener, String Token, String PageNumber, String ArticleId, String ArticleType);

}
