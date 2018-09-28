package news.factory.com.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;


import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import news.factory.com.App;
import news.factory.com.di.module.ActivityModule;
import news.factory.com.di.module.AppModule;
import news.factory.com.di.module.FragmentModule;
import news.factory.com.networking.di.ServiceModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ActivityModule.class,
        ServiceModule.class,
        AppModule.class,
        FragmentModule.class,
        AndroidSupportInjectionModule.class
})

public interface AppComponent extends AndroidInjector<Application> {
    void inject(App application);
}
