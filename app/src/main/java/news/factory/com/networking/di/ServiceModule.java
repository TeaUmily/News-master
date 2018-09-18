package news.factory.com.networking.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maradroid.dummyresponsegenerator.base.DRGInterceptor;
import com.maradroid.dummyresponsegenerator.utils.ConstKt;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import news.factory.com.App;
import news.factory.com.constants.Constants;
import news.factory.com.networking.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {


    @Singleton
    @Provides
    public ApiService apiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl(Constants.NEWS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public OkHttpClient okHttpClient(App app, HttpLoggingInterceptor loggingInterceptor){
        return  new  OkHttpClient.Builder().addInterceptor(loggingInterceptor())
                .addInterceptor(new DRGInterceptor(app, ConstKt.CONTENT_TYPE_JSON)).build();
    }

    @Singleton
    @Provides
    public HttpLoggingInterceptor loggingInterceptor(){
        return new
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Singleton
    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        return gsonBuilder.create();
    }



}
