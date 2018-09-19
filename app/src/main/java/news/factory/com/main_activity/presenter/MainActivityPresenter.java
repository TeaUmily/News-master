package news.factory.com.main_activity.presenter;


import javax.inject.Inject;

import news.factory.com.base_interactor.InteractorWrapper;
import news.factory.com.interaction.article_interactor.ArticleInteractor;
import news.factory.com.constants.Constants;
import news.factory.com.main_activity.contract.MainActivityContract;
import news.factory.com.model.Article;
import news.factory.com.helpers.listeners.NetworkResponseListener;

public class MainActivityPresenter implements MainActivityContract.Presenter, NetworkResponseListener{

    private MainActivityContract.View mainActivityView;
    private ArticleInteractor interactor;


    @Inject
    public MainActivityPresenter(MainActivityContract.View mMainActivityView, ArticleInteractor interactor) {
        this.mainActivityView = mMainActivityView;
        this.interactor = interactor;
    }

    @Override
    public void getNumberOfPages() {
        interactor.getArticle(this, Constants.TOKEN, Constants.PAGE_NUMBER, Constants.ARTICLE_ID, Constants.ARTICLE_TYPE);
    }

    @Override
    public void onSuccess(InteractorWrapper callback) {

        Article article = (Article) callback.getData();
        mainActivityView.setAdapter(Integer.valueOf(article.getPages_no()));

    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
