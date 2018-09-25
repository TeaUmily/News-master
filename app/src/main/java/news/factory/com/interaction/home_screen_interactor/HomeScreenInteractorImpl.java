package news.factory.com.interaction.home_screen_interactor;

import android.arch.lifecycle.LifecycleObserver;

import javax.inject.Inject;

import news.factory.com.base.base_interactor.BaseInteractor;
import news.factory.com.networking.ApiService;

public class HomeScreenInteractorImpl implements HomeScreenInteractor {


    ApiService apiService;

    @Inject
    public HomeScreenInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    
}
