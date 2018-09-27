package news.factory.com.base.base_recycler.view_holders.home_page;

import java.util.List;


import news.factory.com.model.Articles;

public class HomePageHeaderData {

    private List<Articles>  articles;


    public HomePageHeaderData(List<Articles> articles) {
        this.articles = articles;
    }


    public List<Articles> getArticles() {
        return articles;
    }
}
