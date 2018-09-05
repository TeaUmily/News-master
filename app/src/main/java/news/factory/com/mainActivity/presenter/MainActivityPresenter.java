package news.factory.com.mainActivity.presenter;


import news.factory.com.App;
import news.factory.com.interaction.ArticleInteractor;
import news.factory.com.interaction.ArticleInteractorImpl;
import news.factory.com.constants.Constants;
import news.factory.com.mainActivity.contract.MainActivityContract;
import news.factory.com.article.model.Article;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mMainActivityView;

    private ArticleInteractor mInteractor;


    public MainActivityPresenter(MainActivityContract.View mMainActivityView) {
        this.mMainActivityView = mMainActivityView;
        this.mInteractor = new ArticleInteractorImpl(App.getApiService());
    }


    @Override
    public void getNumberOfPages() {
        mInteractor.getArticle(getArticleCallback(), Constants.TOKEN, Constants.PAGE_NUMBER, Constants.ARTICLE_ID, Constants.ARTICLE_TYPE);
    }


    private Callback<Article> getArticleCallback() {
        return new Callback<Article>() {

            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if (response.isSuccessful() && response.body() != null) {
                   mMainActivityView.setAdapter(Integer.valueOf(response.body().getPages_no()));
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        };
    }
}
