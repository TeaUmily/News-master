package news.factory.com.model;

import java.util.List;

public class Category {

    private String stranica;

    private List<Article> articles;

    private String category_id;

    private String page;


    private String categoryName;


    public List<Article> getArticles() {
        return articles;
    }


    public void setArticles (List<Article> articles)
    {
        this.articles = articles;
    }

    public String getCategory_id ()
    {
        return category_id;
    }

    public void setCategory_id (String category_id)
    {
        this.category_id = category_id;
    }


    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;

    }



}
