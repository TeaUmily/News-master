package news.factory.com.base.base_recycler.view_holders.home_news_categories;

import java.util.List;

import news.factory.com.model.Articles;

public class NewsCategoriesData {

  private List<Articles> articles;

    public NewsCategoriesData(List<Articles> articles) {
        this.articles = articles;
    }

    public List<Articles> getArticles() {
        return articles;
    }
}
