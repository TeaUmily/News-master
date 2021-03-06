package news.factory.com.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Featured_image
{
    @Expose
    private String slider;

    @SerializedName("3xl")
    private String xxxl;

    @Expose
    private String s;

    @Expose
    private String xxl;

    @Expose
    private String xl;

    @Expose
    private String original;

    @Expose
    private String xs;

    @Expose
    private String xxs;

    @Expose
    private String l;

    @Expose
    private String m;

    public String getSlider ()
    {
        return slider;
    }

    public void setSlider (String slider)
    {
        this.slider = slider;
    }

    public String getxxxl ()
    {
        return xxxl;
    }

    public void setxxxl (String xxxl)
    {
        this.xxxl = xxxl;
    }

    public String getS ()
    {
        return s;
    }

    public void setS (String s)
    {
        this.s = s;
    }

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

    public String getXs ()
    {
        return xs;
    }

    public void setXs (String xs)
    {
        this.xs = xs;
    }

    public String getXxs ()
    {
        return xxs;
    }

    public void setXxs (String xxs)
    {
        this.xxs = xxs;
    }

    public String getL ()
    {
        return l;
    }

    public void setL (String l)
    {
        this.l = l;
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
        return "ClassPojo [slider = "+slider+", 3xl = "+xxxl+", s = "+s+", xxl = "+xxl+", xl = "+xl+", original = "+original+", xs = "+xs+", xxs = "+xxs+", l = "+l+", m = "+m+"]";
    }
}

