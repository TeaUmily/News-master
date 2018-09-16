package news.factory.com.article_fragment.di;

import dagger.Module;
import dagger.Provides;
import news.factory.com.helpers.ResourcesProviderImpl;
import news.factory.com.article_fragment.contract.ArticleDisplayContract;
import news.factory.com.article_fragment.presenter.ArticlePresenter;
import news.factory.com.article_fragment.view.ArticleFragment;
import news.factory.com.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.interaction.ArticleInteractor;

@Module
public class ArticleFragmentModule {

    @Provides
    RecyclerAdapter provideRecyclerAdapter(){
        return new RecyclerAdapter();
    }

    @Provides
    ArticleDisplayContract.View provideArticleFragmentView(ArticleFragment fragment){
        return fragment;
    }

    @Provides
    ArticleDisplayContract.Presenter provideArticlePresenter(ArticleDisplayContract.View articleFragment, ArticleInteractor interactor, ResourcesProviderImpl context)
    {
        return new ArticlePresenter(articleFragment, interactor, context );
    }

}
