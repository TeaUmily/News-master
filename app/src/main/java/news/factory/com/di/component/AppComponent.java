package news.factory.com.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;


import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import news.factory.com.App;
import news.factory.com.di.module.ActivityModule;
import news.factory.com.di.module.AppModule;
import news.factory.com.di.module.FragmentModule;
import news.factory.com.di.module.ServiceModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ActivityModule.class,
        ServiceModule.class,
        AppModule.class,
        FragmentModule.class

})

public interface AppComponent extends AndroidInjector<Application> {
    void inject(App application);
}
