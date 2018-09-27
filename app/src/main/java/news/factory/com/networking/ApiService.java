package news.factory.com.networking;



import java.util.List;

import io.reactivex.Observable;
import news.factory.com.model.Article;
import news.factory.com.model.Category;
import news.factory.com.model.HomePageArticles;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("{type}/{id}")
    Observable<Article> getArticle(@Path ("type") String articleType , @Path ("id") String articleId, @Query ("api_token") String token, @Query("stranica") String PageNumber);


    @GET("{type}/{id}")
    Observable<Category> getArticles(@Path("type") String category, @Path("id") String id, @Query("api_token") String token, @Query("stranica") String pageNumber);


    @GET ("{type}")
    Observable<List<HomePageArticles>>  getArticles(@Path("type") String index, @Query("api_token") String token);

}
