package news.factory.com.di.module;



import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import news.factory.com.article_categories_fragment.CategoriesFragment;
import news.factory.com.article_categories_fragment.di.CategoriesFragmentModule;
import news.factory.com.article_fragment.di.ArticleFragmentModule;
import news.factory.com.article_fragment.ArticleFragment;
import news.factory.com.home_page_fragment.HomePageFragment;
import news.factory.com.home_page_fragment.di.HomePageFragmentModule;
import news.factory.com.scopes.PerFragment;

@Module
public abstract class FragmentModule {

    @PerFragment
    @ContributesAndroidInjector(modules = ArticleFragmentModule.class)
    public abstract ArticleFragment provideArticleFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = CategoriesFragmentModule.class)
    public abstract CategoriesFragment provideCategoriesFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = HomePageFragmentModule.class)
    public abstract HomePageFragment provideHomeFragment();

}