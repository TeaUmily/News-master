package news.factory.com.base.recycler.view_holders.article_featured_image;

public class ArticleFeaturedImageData {


    private String image;
    private String category;
    private String source;

    public ArticleFeaturedImageData(String image, String category, String source) {
        this.image = image;
        this.category = category;
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getSource() {
        return source;
    }
}
