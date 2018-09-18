package news.factory.com.helpers.resources_provider;

public interface ResourcesProvider {

     String provideString(int stringID);

     String provideString(int stringID, String data);

     int provideColor(int colorID);
}