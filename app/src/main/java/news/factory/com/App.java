package news.factory.com;

import android.app.Application;

import com.maradroid.dummyresponsegenerator.base.interactor.InteractorImpl;
import com.maradroid.dummyresponsegenerator.utils.SharedPerfRepo;

import news.factory.com.constants.Constants;
import news.factory.com.interaction.ApiInteractor;
import news.factory.com.interaction.ApiInteractorImpl;
import news.factory.com.networking.ApiService;
import news.factory.com.networking.RetrofitUtil;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static App sInstance;
    private static ApiInteractor mApiInteractor;

    @Override
    public void onCreate() {

        super.onCreate();
        sInstance= this;

        final Retrofit retrofit = RetrofitUtil.createRetrofit();
        final ApiService apiService = retrofit.create(ApiService.class);

        mApiInteractor = new ApiInteractorImpl(apiService);

        new InteractorImpl(this).generateResponses(true);
        new SharedPerfRepo(this).setDummyResponse(true);
    }


    public static App getInstance() {
        return sInstance;
    }

    public static ApiInteractor getApiInteractor() {
        return mApiInteractor;
    }

}
