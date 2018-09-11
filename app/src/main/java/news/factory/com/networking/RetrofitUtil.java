package news.factory.com.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maradroid.dummyresponsegenerator.base.DRGInterceptor;
import com.maradroid.dummyresponsegenerator.utils.ConstKt;

import news.factory.com.App;
import news.factory.com.constants.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    public static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.NEWS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient())
                .build();
    }

    public static Gson getGson() {
        return getCommonBuilder()
                .create();
    }

    private static GsonBuilder getCommonBuilder() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
    }

    private static HttpLoggingInterceptor provideLoggingInterceptor() {
        return new
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }


    private static OkHttpClient okHttpClient() {
        return new
                OkHttpClient.Builder().addInterceptor(provideLoggingInterceptor()).addInterceptor(new DRGInterceptor(App.getInstance(), ConstKt.CONTENT_TYPE_JSON)).build();
    }

}
