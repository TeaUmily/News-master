package news.factory.com.di.module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import news.factory.com.main_activity.di.MainActivityModule;
import news.factory.com.main_activity.view.MainActivity;

@Module(subcomponents = {ActivityModule.MainActivitySubcomponent.class,
        FragmentModule.ArticleFragmentSubcomponent.class})
public abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);


    @Subcomponent(modules = {MainActivityModule.class, FragmentModule.class})
    public interface MainActivitySubcomponent extends AndroidInjector<MainActivity>{

        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<MainActivity>{
        }
    }

}