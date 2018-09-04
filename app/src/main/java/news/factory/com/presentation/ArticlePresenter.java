package news.factory.com.presentation;

import news.factory.com.App;
import news.factory.com.constants.Constants;
import news.factory.com.model.Article;
import news.factory.com.ui.articleDisplay.ArticleDisplayContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlePresenter implements ArticleDisplayContract.Presenter {

    private Article mArticle;
    private ArticleDisplayContract.View mArticleFragmentView;

    @Override
    public void setView(ArticleDisplayContract.View articleView) {
       this.mArticleFragmentView = articleView;
    }

    @Override
    public void getArticle() {
        App.getApiInteractor().getArticle(getArticleCallback(), Constants.TOKEN, Constants.PAGE_NUMBER, Constants.ARTICLE_ID, Constants.ARTICLE_TYPE);
    }

    private Callback<Article> getArticleCallback() {
        return new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mArticle = response.body();
                    mArticleFragmentView.showArticle(mArticle);
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        };
    }


}
