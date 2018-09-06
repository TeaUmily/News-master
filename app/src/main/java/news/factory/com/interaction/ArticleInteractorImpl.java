package news.factory.com.interaction;


import news.factory.com.model.Article;
import news.factory.com.networking.ApiService;
import news.factory.com.networking.NetworkResponseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleInteractorImpl implements ArticleInteractor {

    private final ApiService apiService;

    public ArticleInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getArticle(final NetworkResponseListener<Article> listener, String Token, String PageNumber, String ArticleId, String ArticleType) {
        apiService.getArticle(ArticleType, ArticleId, Token, PageNumber).enqueue(new Callback<Article>() {

            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if (response.body()!=null && response.isSuccessful()){
                    Article article= response.body();
                    listener.onSuccess(article);
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

}

