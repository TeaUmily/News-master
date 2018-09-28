package news.factory.com.base.base_recycler.view_holders.article_item;



public class ArticleItemData {

    private String featuredImage;

    private String title;

    private String publishedAtHumans;

    private String category;

    private String numberOfShares;

    private String articeId;

    public ArticleItemData(String featuredImage, String title, String publishedAtHumans, String category, String numberOfShares, String articeId) {
        this.featuredImage = featuredImage;
        this.title = title;
        this.publishedAtHumans = publishedAtHumans;
        this.category = category;
        this.numberOfShares = numberOfShares;
        this.articeId = articeId;
    }

    public ArticleItemData(String featuredImage, String title, String category, String shares, String articeId) {
        this.featuredImage = featuredImage;
        this.title = title;
        this.category = category;
        this.numberOfShares = shares;
        this.articeId = articeId;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishedAtHumans() {
        return publishedAtHumans;
    }


    public String getCategory() {
        return category;
    }


    public String getNumberOfShares() {
        return numberOfShares;
    }

    public String getArticeId() {
        return articeId;
    }

    public void setArticeId(String articeId) {
        this.articeId = articeId;
    }
}
