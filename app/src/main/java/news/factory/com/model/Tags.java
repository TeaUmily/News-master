package news.factory.com.model;

import com.google.gson.annotations.Expose;

public class Tags
{
    @Expose
    private String id;

    @Expose
    private String tag;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTag ()
    {
        return tag;
    }

    public void setTag (String tag)
    {
        this.tag = tag;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", tag = "+tag+"]";
    }
}
