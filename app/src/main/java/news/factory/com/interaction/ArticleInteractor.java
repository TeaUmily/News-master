package news.factory.com.interaction;

import news.factory.com.article.model.Article;
import retrofit2.Callback;

public interface ArticleInteractor {

    void getArticle(Callback<Article> callback, String Token, String PageNumber, String ArticleId, String ArticleType);

}
