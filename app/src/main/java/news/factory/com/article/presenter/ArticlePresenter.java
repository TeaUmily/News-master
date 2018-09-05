package news.factory.com.article.presenter;

import java.util.ArrayList;
import java.util.List;

import news.factory.com.App;
import news.factory.com.article.model.articleListItem.ArticleListItemImage;
import news.factory.com.article.model.articleListItem.ArticleListItemTitle;
import news.factory.com.article.model.articleListItem.ArticleListItem;
import news.factory.com.interaction.ArticleInteractor;
import news.factory.com.interaction.ArticleInteractorImpl;
import news.factory.com.constants.Constants;
import news.factory.com.article.model.Article;
import news.factory.com.article.contract.ArticleDisplayContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlePresenter implements ArticleDisplayContract.Presenter {

    private ArticleInteractor mInteractor;
    private Article mArticle;
    private List<ArticleListItem> mArticleItemList;
    private ArticleDisplayContract.View mArticleFragmentView;


    public ArticlePresenter(ArticleDisplayContract.View mArticleFragmentView) {

        this.mArticleFragmentView = mArticleFragmentView;
        this.mInteractor = new ArticleInteractorImpl(App.getApiService());
        this.mArticleItemList = new ArrayList<>();
    }

    @Override
    public void getArticle(String articleToDisplay) {
       mInteractor.getArticle(getArticleCallback(), Constants.TOKEN, articleToDisplay, Constants.ARTICLE_ID, Constants.ARTICLE_TYPE);
    }


    private Callback<Article> getArticleCallback() {
        return new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mArticle = response.body();
                    mappArticleIntoList(mArticle);
                    mArticleFragmentView.showArticle(mArticleItemList);
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        };
    }

    private void mappArticleIntoList(Article mArticle) {

        if(!mArticle.getNo_featured_image().equals(Constants.ARTICLE_FEATURED_IMAGE)){
            mArticleItemList.add(new ArticleListItemImage(mArticle.getFeatured_image().getOriginal()));
        }

        mArticleItemList.add(new ArticleListItemTitle(mArticle.getTitle()));

        mArticleItemList.addAll(mArticle.getContent());

    }


}
