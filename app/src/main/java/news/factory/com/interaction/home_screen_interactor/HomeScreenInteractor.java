package news.factory.com.interaction.home_screen_interactor;

import news.factory.com.helpers.listeners.NetworkResponseListener;

public interface HomeScreenInteractor {

    void getHomeScreenArticles(NetworkResponseListener listener, String Token, String index );

}
