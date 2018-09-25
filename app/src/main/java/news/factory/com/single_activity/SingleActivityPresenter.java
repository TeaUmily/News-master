package news.factory.com.single_activity;


import javax.inject.Inject;

import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.interaction.article_interaction.ArticleInteractor;
import news.factory.com.constants.Constants;
import news.factory.com.model.Article;
import news.factory.com.helpers.listeners.NetworkResponseListener;

public class SingleActivityPresenter implements SingleActivityContract.Presenter, NetworkResponseListener{

    private SingleActivityContract.View mainActivityView;
    private ArticleInteractor interactor;


    @Inject
    public SingleActivityPresenter(SingleActivityContract.View mMainActivityView, ArticleInteractor interactor) {
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
