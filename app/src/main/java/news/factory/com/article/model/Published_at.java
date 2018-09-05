package news.factory.com.article.model;

import com.google.gson.annotations.Expose;

public class Published_at
{
    @Expose
    private String timezone;

    @Expose
    private String timezone_type;

    @Expose
    private String date;

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getTimezone_type ()
    {
        return timezone_type;
    }

    public void setTimezone_type (String timezone_type)
    {
        this.timezone_type = timezone_type;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timezone = "+timezone+", timezone_type = "+timezone_type+", date = "+date+"]";
    }
}