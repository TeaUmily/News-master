package news.factory.com.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class HomePageArticles {

    @Expose
    private String name;

    @Expose
    private String color;

    @Expose
    private List<Articles> articles;

    public HomePageArticles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }
}
