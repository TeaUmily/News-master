package news.factory.com.di.module;


import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import news.factory.com.article_fragment.di.ArticleFragmentModule;
import news.factory.com.article_fragment.view.ArticleFragment;

@Module (subcomponents = FragmentModule.ArticleFragmentSubcomponent.class )
public abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(ArticleFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindArticleFragmentInjectorFactory(ArticleFragmentSubcomponent.Builder builder);


    @Subcomponent(modules = {ArticleFragmentModule.class})
    public interface ArticleFragmentSubcomponent extends AndroidInjector<ArticleFragment>{

        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<ArticleFragment>{
        }
    }
}
