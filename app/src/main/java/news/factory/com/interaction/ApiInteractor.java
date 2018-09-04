package news.factory.com.interaction;

import news.factory.com.model.Article;
import news.factory.com.model.Response;
import retrofit2.Callback;

public interface ApiInteractor {

    void getArticle(Callback<Article> callback, String Token, String PageNumber, String ArticleId, String ArticleType);

}
