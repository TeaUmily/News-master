package news.factory.com.di.module;



import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import news.factory.com.single_screen.article_categories_fragment.CategoriesFragment;
import news.factory.com.single_screen.article_categories_fragment.di.CategoriesFragmentModule;
import news.factory.com.single_screen.article_fragment.di.ArticleFragmentModule;
import news.factory.com.single_screen.article_fragment.ArticleFragment;
import news.factory.com.home_screen.category_external_fragment.CategoriesExternalFragment;
import news.factory.com.home_screen.category_external_fragment.di.CategoriesExternalFragmentModule;
import news.factory.com.home_screen.category_inner_fragment.CategoryInnerFragment;
import news.factory.com.home_screen.category_inner_fragment.di.CategoyInnerFragmentModule;
import news.factory.com.home_screen.home_page_fragment.HomePageFragment;
import news.factory.com.home_screen.home_page_fragment.di.HomePageFragmentModule;
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

    @PerFragment
    @ContributesAndroidInjector(modules = CategoriesExternalFragmentModule.class)
    public abstract CategoriesExternalFragment provideCategoriesExternalFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = CategoyInnerFragmentModule.class)
    public abstract CategoryInnerFragment provideCategoryInnerFragment();

}