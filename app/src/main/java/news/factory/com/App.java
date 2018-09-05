package news.factory.com;

import android.app.Application;

import com.maradroid.dummyresponsegenerator.base.interactor.InteractorImpl;
import com.maradroid.dummyresponsegenerator.utils.SharedPerfRepo;

import news.factory.com.interaction.ArticleInteractor;
import news.factory.com.interaction.ArticleInteractorImpl;
import news.factory.com.networking.ApiService;
import news.factory.com.networking.RetrofitUtil;
import retrofit2.Retrofit;

public class App extends Application {

    private static App sInstance;
    private static ApiService mApiService;

    @Override
    public void onCreate() {

        super.onCreate();
        sInstance= this;

        final Retrofit retrofit = RetrofitUtil.createRetrofit();
        mApiService = retrofit.create(ApiService.class);

        new InteractorImpl(this).generateResponses(true);
        new SharedPerfRepo(this).setDummyResponse(true);
    }

    public static App getInstance() {
        return sInstance;
    }

    public static ApiService getApiService() {
        return mApiService;
    }

}
