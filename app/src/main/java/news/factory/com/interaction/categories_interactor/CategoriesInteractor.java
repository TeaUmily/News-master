package news.factory.com.interaction.categories_interactor;

import news.factory.com.helpers.listeners.NetworkResponseListener;

public interface CategoriesInteractor {

    void getArticles(NetworkResponseListener listener, String Token, String PageNumber, String ArticleId, String ArticleType);

}
