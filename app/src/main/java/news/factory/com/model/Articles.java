package news.factory.com.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Articles implements Serializable{


    @Expose
    @SerializedName("featured_image")
    private Featured_image featuredImage;

    @Expose
    private String title;

    @Expose
    private String shares;

    @Expose
    @SerializedName("published_at_humans")
    private String publishedAtHumans;

    @Expose
    @SerializedName("category_slug")
    private String category;

    public Articles() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishedAtHumans() {
        return publishedAtHumans;
    }

    public void setPublishedAtHumans(String publishedAtHumans) {
        this.publishedAtHumans = publishedAtHumans;
    }


    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public Featured_image getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(Featured_image featuredImage) {
        this.featuredImage = featuredImage;
    }
}
