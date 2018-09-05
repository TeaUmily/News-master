package news.factory.com.networking;


import news.factory.com.article.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("{type}/{id}")
    Call<Article> getArticle(@Path ("type") String articleType ,@Path ("id") String articleId, @Query ("api_token") String token, @Query("stranica") String PageNumber);

}
