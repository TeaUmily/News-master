package news.factory.com.di.module;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import news.factory.com.home_screen.home_activity.HomeActivity;
import news.factory.com.home_screen.home_activity.di.HomeActivityModule;
import news.factory.com.single_screen.single_activity.di.SingleActivityModule;
import news.factory.com.single_screen.single_activity.SingleActivity;
import news.factory.com.scopes.PerActivity;

@Module
public abstract class ActivityModule {

        @PerActivity
        @ContributesAndroidInjector(modules = SingleActivityModule.class)
        public abstract SingleActivity provideMainActivity();


        @PerActivity
        @ContributesAndroidInjector(modules = HomeActivityModule.class)
        public abstract HomeActivity provideHomeActivity();


}