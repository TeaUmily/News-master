package news.factory.com.article.model.articleListItem;

public class ArticleListItemTitle implements ArticleListItem {

    private String title;

    public ArticleListItemTitle(String title) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
