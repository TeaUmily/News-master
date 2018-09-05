package news.factory.com.article.model.articleListItem;


public class ArticleListItemImage implements ArticleListItem {


    private String image;

    public ArticleListItemImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
