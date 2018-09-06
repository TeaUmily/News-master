package news.factory.com.article_fragment.presenter;

import java.util.ArrayList;
import java.util.List;

import news.factory.com.App;
import news.factory.com.base.recycler.RecyclerWrapper;
import news.factory.com.base.recycler.view_holders.article_featured_image.ArticleFeaturedImageData;
import news.factory.com.base.recycler.view_holders.article_image.ArticleImageData;
import news.factory.com.base.recycler.view_holders.article_text.ArticleTextData;
import news.factory.com.base.recycler.view_holders.article_title.ArticleTitleData;
import news.factory.com.model.Content;
import news.factory.com.interaction.ArticleInteractor;
import news.factory.com.interaction.ArticleInteractorImpl;
import news.factory.com.constants.Constants;
import news.factory.com.model.Article;
import news.factory.com.article_fragment.contract.ArticleDisplayContract;
import news.factory.com.networking.NetworkResponseListener;

public class ArticlePresenter implements ArticleDisplayContract.Presenter, NetworkResponseListener{

    private ArticleInteractor interactor;
    private ArticleDisplayContract.View articleFragmentView;


    public ArticlePresenter(ArticleDisplayContract.View mArticleFragmentView) {
        this.articleFragmentView = mArticleFragmentView;
        this.interactor = new ArticleInteractorImpl(App.getApiService());
    }

    @Override
    public void getArticle(String articleToDisplay) {
        interactor.getArticle(this,Constants.TOKEN, articleToDisplay, Constants.ARTICLE_ID, Constants.ARTICLE_TYPE );
    }

    @Override
    public void onSuccess(Object callback) {
        Article article = (Article) callback;
        articleFragmentView.showArticle(getArticleMappedList(article));
    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    private List<RecyclerWrapper> getArticleMappedList(Article article) {

        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();

        if(!article.getNo_featured_image().equals(Constants.ARTICLE_FEATURED_IMAGE)){
           recyclerWrappers.add(new RecyclerWrapper(new ArticleFeaturedImageData(article.getFeatured_image().getOriginal(), article.getCategory(), article.getFeatured_image_source()),RecyclerWrapper.TYPE_FEATURED_IMAGE));
        }

        recyclerWrappers.add(new RecyclerWrapper(new ArticleTitleData(article.getTitle()), RecyclerWrapper.TYPE_TITLE));

        for (Content content : article.getContent()
             ) {

            if(content.getType().equals(Constants.ARTICLE_TYPE_TEXT)){
                recyclerWrappers.add(new RecyclerWrapper(new ArticleTextData(content.getData()), RecyclerWrapper.TYPE_TEXT));
            }
            else if(content.getType().equals(Constants.ARTICLE_TYPE_IMAGE)){
                recyclerWrappers.add(new RecyclerWrapper(new ArticleImageData(content.getImage().getOriginal()), RecyclerWrapper.TYPE_IMAGE));
            }
        }

        return recyclerWrappers;
    }
}
