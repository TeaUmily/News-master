package news.factory.com.interaction;


import news.factory.com.model.Article;
import news.factory.com.model.Response;
import news.factory.com.networking.ApiService;
import retrofit2.Callback;

public class ApiInteractorImpl implements ApiInteractor{

    private final ApiService mApiService;

    public ApiInteractorImpl(ApiService apiService) {
        this.mApiService = apiService;
    }


    @Override
    public void getArticle(Callback<Article> callback, String Token, String PageNumber, String ArticleId, String ArticleType) {
        mApiService.getArticle(ArticleType, ArticleId, Token, PageNumber).enqueue(callback);
    }

}

