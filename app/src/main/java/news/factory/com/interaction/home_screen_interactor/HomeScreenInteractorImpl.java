package news.factory.com.interaction.home_screen_interactor;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import news.factory.com.base.base_interactor.BaseInteractor;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.helpers.listeners.NetworkResponseListener;
import news.factory.com.model.HomePageArticles;
import news.factory.com.networking.ApiService;

public class HomeScreenInteractorImpl extends BaseInteractor implements HomeScreenInteractor {


    ApiService apiService;

    @Inject
    public HomeScreenInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public void getHomeScreenArticles(NetworkResponseListener listener, String Token, String index) {

        apiService.getArticles(index, Token).subscribeOn(Schedulers.io())
                .map(new Function<List<HomePageArticles>, InteractorWrapper>() {
                    @Override
                    public InteractorWrapper apply(List<HomePageArticles> list) throws Exception {
                        InteractorWrapper data = new InteractorWrapper(list);
                        return data;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(provideDisposableObserver(listener));

    }
}
