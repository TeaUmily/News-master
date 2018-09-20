package news.factory.com.base.base_recycler.view_holders.article_item;



public class ArticleItemData {


    private String featuredImageSource;

    private String title;

    private String publishedAtHumans;

    private String category;

    private String numberOfShares;

    public ArticleItemData(String featuredImageSource, String title, String publishedAtHumans, String category, String numberOfShares) {
        this.featuredImageSource = featuredImageSource;
        this.title = title;
        this.publishedAtHumans = publishedAtHumans;
        this.category = category;
        this.numberOfShares = numberOfShares;
    }

    public String getFeaturedImageSource() {
        return featuredImageSource;
    }

    public void setFeaturedImageSource(String featuredImageSource) {
        this.featuredImageSource = featuredImageSource;
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
}
