package news.factory.com.helpers;

public interface ResourcesProvider {

     String provideString(int stringID);

     String provideString(int stringID, String data);

     int provideColor(int colorID);
}