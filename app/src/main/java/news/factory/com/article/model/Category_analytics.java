package news.factory.com.article.model;

import com.google.gson.annotations.Expose;

public class Category_analytics
{
    @Expose
    private String dotmetrics;

    public String getDotmetrics ()
    {
        return dotmetrics;
    }

    public void setDotmetrics (String dotmetrics)
    {
        this.dotmetrics = dotmetrics;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dotmetrics = "+dotmetrics+"]";
    }
}
