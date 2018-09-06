package news.factory.com.interaction;

import news.factory.com.model.Article;
import news.factory.com.networking.NetworkResponseListener;

public interface ArticleInteractor {

    void getArticle(NetworkResponseListener<Article> listener, String Token, String PageNumber, String ArticleId, String ArticleType);

}
