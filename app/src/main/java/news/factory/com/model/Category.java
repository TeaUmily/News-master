package news.factory.com.model;



import com.google.gson.annotations.Expose;

import java.util.List;

public class Category {

    @Expose
    private List<Articles> articles;

    @Expose
    private String name;

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles (List<Articles> articles)
    {
        this.articles = articles;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
