package news.factory.com.article.model;

import com.google.gson.annotations.Expose;

public class Image {

    @Expose
    private String xxl;
    @Expose
    private String xl;
    @Expose
    private String original;
    @Expose
    private String m;

    public String getXxl ()
    {
        return xxl;
    }

    public void setXxl (String xxl)
    {
        this.xxl = xxl;
    }

    public String getXl ()
    {
        return xl;
    }

    public void setXl (String xl)
    {
        this.xl = xl;
    }

    public String getOriginal ()
    {
        return original;
    }

    public void setOriginal (String original)
    {
        this.original = original;
    }

    public String getM ()
    {
        return m;
    }

    public void setM (String m)
    {
        this.m = m;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [xxl = "+xxl+", xl = "+xl+", original = "+original+", m = "+m+"]";
    }
}

