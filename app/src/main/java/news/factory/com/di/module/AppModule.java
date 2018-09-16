package news.factory.com.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import news.factory.com.App;
import news.factory.com.helpers.ResourcesProviderImpl;

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    App provideContext(){
        return app;
    }

    @Singleton
    @Provides
    ResourcesProviderImpl provideResourceRepo(App app){
        return new ResourcesProviderImpl(app);
    }
}
