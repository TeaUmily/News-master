package news.factory.com.interaction;


import news.factory.com.article.model.Article;
import news.factory.com.networking.ApiService;
import retrofit2.Callback;

public class ArticleInteractorImpl implements ArticleInteractor {

    private final ApiService mApiService;

    public ArticleInteractorImpl(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public void getArticle(Callback<Article> callback, String Token, String PageNumber, String ArticleId, String ArticleType) {
        mApiService.getArticle(ArticleType, ArticleId, Token, PageNumber).enqueue(callback);
    }

}

