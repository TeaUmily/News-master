package news.factory.com.article_fragment.di;

        import dagger.Module;
        import dagger.Provides;
        import news.factory.com.article_fragment.contract.ArticleDisplayContract;
        import news.factory.com.article_fragment.presenter.ArticlePresenter;
        import news.factory.com.article_fragment.view.ArticleFragment;
        import news.factory.com.base_recycler.adapter.RecyclerAdapter;
        import news.factory.com.base_recycler.adapter.RecyclerAdapterImpl;
        import news.factory.com.interaction.ArticleInteractor;
        import news.factory.com.interaction.ArticleInteractorImpl;
        import news.factory.com.scopes.PerFragment;

@Module
public class ArticleFragmentModule {


    @PerFragment
    @Provides
    RecyclerAdapter provideRecyclerAdapterImpl(RecyclerAdapterImpl adapter){
        return adapter;
    }

    @PerFragment
    @Provides
    RecyclerAdapterImpl provideRecyclerAdapter(ArticlePresenter presenter){
        return new RecyclerAdapterImpl(presenter);
    }


    @PerFragment
    @Provides
    ArticleDisplayContract.View provideArticleFragmentView(ArticleFragment fragment){
        return fragment;
    }

    @PerFragment
    @Provides
    ArticleInteractor provideArticleInteractor(ArticleInteractorImpl interactor, ArticleFragment articleFragment){
        articleFragment.getLifecycle().addObserver(interactor);
        return interactor;
    }

    @PerFragment
    @Provides
    ArticleDisplayContract.Presenter provideArticlePresenter(ArticlePresenter articlePresenter)
    {
        return articlePresenter;
    }

}
