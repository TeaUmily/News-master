package news.factory.com.article_fragment.di;

        import dagger.Module;
        import dagger.Provides;
        import news.factory.com.article_fragment.ArticleContract;
        import news.factory.com.article_fragment.ArticlePresenter;
        import news.factory.com.article_fragment.ArticleFragment;
        import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
        import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
        import news.factory.com.base.base_recycler.view_holders.article_categories.CategoriesPagerAdapter;
        import news.factory.com.interaction.article_interaction.ArticleInteractor;
        import news.factory.com.interaction.article_interaction.ArticleInteractorImpl;
        import news.factory.com.scopes.PerFragment;

@Module
public class ArticleFragmentModule {

    @PerFragment
    @Provides
    RecyclerAdapter provideRecyclerAdapter(RecyclerAdapterImpl adapter){
        return adapter;
    }

    @PerFragment
    @Provides
    RecyclerAdapterImpl provideRecyclerAdapterImpl(ArticlePresenter presenter){
        return new RecyclerAdapterImpl(presenter);
    }

    @PerFragment
    @Provides
    ArticleContract.View provideArticleFragmentView(ArticleFragment fragment){
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
    ArticleContract.Presenter provideArticlePresenter(ArticlePresenter articlePresenter)
    {
        return articlePresenter;
    }

    @PerFragment
    @Provides
        CategoriesPagerAdapter providePagerAdapter(ArticleFragment fragment){
            return new CategoriesPagerAdapter(fragment.getChildFragmentManager());
    }
}
