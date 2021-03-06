package news.factory.com.single_screen.article_fragment;




import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import news.factory.com.R;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.helpers.resources_provider.ResourcesProviderImpl;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.base.base_recycler.view_holders.article_author_shares.ArticleAuthorAndSharesData;
import news.factory.com.base.base_recycler.view_holders.article_featured_image.ArticleFeaturedImageData;
import news.factory.com.base.base_recycler.view_holders.article_image.ArticleImageData;
import news.factory.com.base.base_recycler.view_holders.article_page_indicator.ArticlePageIndicatorData;
import news.factory.com.base.base_recycler.view_holders.article_publication_date.ArticlePublicationDateData;
import news.factory.com.base.base_recycler.view_holders.article_text.ArticleTextData;
import news.factory.com.base.base_recycler.view_holders.article_title.ArticleTitleData;
import news.factory.com.base.base_recycler.view_holders.article_upper_tittle.ArticleUpperTitleData;
import news.factory.com.model.Content;
import news.factory.com.interaction.article_interaction.ArticleInteractor;
import news.factory.com.constants.Constants;
import news.factory.com.model.Article;
import news.factory.com.helpers.listeners.NetworkResponseListener;

public class ArticlePresenter implements ArticleContract.Presenter, NetworkResponseListener{

    public static String ARTICLE_ID = "0";

    private ArticleInteractor interactor;
    private ArticleContract.View articleFragmentView;

    private String articlePageNumber;
    private ResourcesProviderImpl context;

    private Lazy<RecyclerAdapter> recyclerAdapterlazy;


    @Inject
    public ArticlePresenter(ArticleContract.View articleFragmentView, ArticleInteractor interactor, ResourcesProviderImpl context, Lazy<RecyclerAdapter> adapterLazy) {
        this.articleFragmentView = articleFragmentView;
        this.interactor = interactor;
        this.context = context;
        this.recyclerAdapterlazy = adapterLazy;
    }

    @Override
    public void getArticle(String pageNumber) {
        this.articlePageNumber = pageNumber;
        interactor.getArticle(this,Constants.TOKEN, articlePageNumber, ARTICLE_ID, Constants.ARTICLE_TYPE );
    }

    @Override
    public void onSuccess(InteractorWrapper callback) {
        Article article = (Article) callback.getData();
        recyclerAdapterlazy.get().addItems(getArticleMappedList(article));
    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    private List<RecyclerWrapper> getArticleMappedList(Article article) {

        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();

        mappFeaturedImage(recyclerWrappers, article);
        mappUpperTitle(recyclerWrappers, article);
        mapppAuthorAndShares(recyclerWrappers, article);
        mappTitle(recyclerWrappers, article);
        mappContent(recyclerWrappers,article);
        mappPublicationDate(recyclerWrappers, article);
        mappIndicator(recyclerWrappers, article);
        mappArticleCategories(recyclerWrappers);

        return recyclerWrappers;
    }

    private void mappArticleCategories(List<RecyclerWrapper> recyclerWrappers) {
        recyclerWrappers.add(new RecyclerWrapper(RecyclerWrapper.TYPE_ARTICLE_CATEGORIES));
    }

    private void mappIndicator(List<RecyclerWrapper> recyclerWrappers, Article article) {
        recyclerWrappers.add(new RecyclerWrapper(new ArticlePageIndicatorData(article.getPages_no(),articlePageNumber), RecyclerWrapper.TYPE_PAGE_INDICATOR));

    }

    private void mappPublicationDate(List<RecyclerWrapper> recyclerWrappers, Article article) {
        String publicationDate = article.getPublishedAtHumans().split(" ")[0];
        recyclerWrappers.add(new RecyclerWrapper(new ArticlePublicationDateData(context.provideString(R.string.published,publicationDate)), RecyclerWrapper.TYPE_PUBLICATION_DATE));
    }

    private void mappContent(List<RecyclerWrapper> recyclerWrappers, Article article) {

        for (Content content : article.getContent()
                ) {

            if(content.getType().equals(Constants.ARTICLE_TYPE_TEXT)){
                recyclerWrappers.add(new RecyclerWrapper(new ArticleTextData(content.getData()), RecyclerWrapper.TYPE_TEXT));
            }
            else if(content.getType().equals(Constants.ARTICLE_TYPE_IMAGE)){
                String imagePath = Constants.IMAGE_BASE_URL + content.getImage().getOriginal();
                recyclerWrappers.add(new RecyclerWrapper(new ArticleImageData(imagePath), RecyclerWrapper.TYPE_IMAGE));
            }
        }

    }

    private void mappTitle(List<RecyclerWrapper> recyclerWrappers, Article article) {
        recyclerWrappers.add(new RecyclerWrapper(new ArticleTitleData(article.getTitle()), RecyclerWrapper.TYPE_TITLE));

    }

    private void mapppAuthorAndShares(List<RecyclerWrapper> recyclerWrappers, Article article) {
        recyclerWrappers.add(new RecyclerWrapper(new ArticleAuthorAndSharesData(article.getAuthor(), article.getShares()), RecyclerWrapper.TYPE_AUTHOR));
    }

    private void mappUpperTitle(List<RecyclerWrapper> recyclerWrappers, Article article) {

        if(!article.getUppertitle().isEmpty()){
            recyclerWrappers.add(new RecyclerWrapper(new ArticleUpperTitleData(article.getUppertitle()), RecyclerWrapper.TYPE_UPPER_TITLE));
        }
    }

    private void mappFeaturedImage(List<RecyclerWrapper> recyclerWrappers, Article article) {

        ArticleFeaturedImageData featuredImageData;
        String source = "";

        if(!article.getFeaturedImageSource().isEmpty()){
            source = context.provideString(R.string.source, article.getFeaturedImageSource());
        }

        if(article.getNo_featured_image().equals(Constants.ARTICLE_FEATURED_IMAGE)){

            featuredImageData = new ArticleFeaturedImageData(article.getFeatured_image().getOriginal(), article.getCategory(),source, article.getFeaturedImageCaption());
            recyclerWrappers.add(new RecyclerWrapper(featuredImageData,RecyclerWrapper.TYPE_FEATURED_IMAGE));
        }
        else{

            featuredImageData = new ArticleFeaturedImageData(article.getCategory(), article.getFeaturedImageSource(), article.getFeaturedImageCaption());
            featuredImageData.setTextColor(context.provideColor(R.color.black));
            recyclerWrappers.add(new RecyclerWrapper(featuredImageData,RecyclerWrapper.TYPE_FEATURED_IMAGE));
        }

    }

    @Override
    public String getArticlePageNumber() {
        return articlePageNumber;
    }


}
