package news.factory.com.helpers.resources_provider;

import android.content.Context;

import javax.inject.Inject;

public class ResourcesProviderImpl implements ResourcesProvider {

    private Context appContext;

    @Inject
    public ResourcesProviderImpl(Context appContext) {
        this.appContext = appContext;
    }

    public String provideString(int stringID) {
        return appContext.getString(stringID);
    }

    public String provideString(int stringID, String data) {
        return appContext.getString(stringID, data);
    }

    public int provideColor(int colorID) {
        return appContext.getResources().getColor(colorID);
    }
}
