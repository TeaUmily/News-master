package news.factory.com.base.base_recycler.view_holders.article_featured_image;


public class ArticleFeaturedImageData {


    private String image;
    private String category;
    private String source;
    private String caption;
    private int textColor;

    public ArticleFeaturedImageData(String image, String category, String source, String caption) {
        this.image = image;
        this.category = category;
        this.source = source;
        this.caption = caption;
    }

    public ArticleFeaturedImageData(String category, String source, String caption) {
        this.category = category;
        this.source = source;
        this.caption = caption;
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

    public String getCaption() {
        return caption;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
