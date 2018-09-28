package news.factory.com.home_screen.home_activity;


import java.util.List;

import javax.inject.Inject;

import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.constants.Constants;
import news.factory.com.helpers.listeners.NetworkResponseListener;
import news.factory.com.interaction.home_screen_interactor.HomeScreenInteractor;
import news.factory.com.model.HomeMenuBottomItem;

public class HomeActivityPresenter implements HomeActivityContract.Presenter, NetworkResponseListener{


    private HomeActivityContract.View homeActivityView;
    private HomeScreenInteractor interactor;

    @Inject
    public HomeActivityPresenter (HomeActivityContract.View homeActivityView, HomeScreenInteractor interactor ){
        this.homeActivityView = homeActivityView;
        this.interactor = interactor;
    }


    @Override
    public void getBottomMenuTitles() {
        interactor.getHomeScreenBottomTitles(this, Constants.TOKEN, Constants.MENU_BOTTOM);
    }

    @Override
    public void onSuccess(InteractorWrapper callback) {
        List<HomeMenuBottomItem> dataList = (List<HomeMenuBottomItem>) callback.getData();
        homeActivityView.setHomeScreenView(dataList);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
