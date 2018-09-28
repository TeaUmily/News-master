package news.factory.com.model;

import com.google.gson.annotations.Expose;

public class HomeMenuBottomItem {

    @Expose
    private String title;

    @Expose
    private String color;


    public HomeMenuBottomItem() {
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }
}
