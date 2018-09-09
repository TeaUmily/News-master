package news.factory.com.main_activity.presenter;

import news.factory.com.App;
import news.factory.com.interaction.ArticleInteractor;
import news.factory.com.interaction.ArticleInteractorImpl;
import news.factory.com.constants.Constants;
import news.factory.com.main_activity.contract.MainActivityContract;
import news.factory.com.model.Article;
import news.factory.com.networking.NetworkResponseListener;

public class MainActivityPresenter implements MainActivityContract.Presenter, NetworkResponseListener{

    private MainActivityContract.View mainActivityView;
    private ArticleInteractor interactor;


    public MainActivityPresenter(MainActivityContract.View mMainActivityView) {
        this.mainActivityView = mMainActivityView;
        this.interactor = new ArticleInteractorImpl(App.getApiService());
    }

    @Override
    public void getNumberOfPages() {
        interactor.getArticle(this, Constants.TOKEN, Constants.PAGE_NUMBER, Constants.ARTICLE_ID, Constants.ARTICLE_TYPE);
    }

    @Override
    public void onSuccess(Object callback) {

        Article article = (Article) callback;
        mainActivityView.setAdapter(Integer.valueOf(article.getPages_no()));

    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
