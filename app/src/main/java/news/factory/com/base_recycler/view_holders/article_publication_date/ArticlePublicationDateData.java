package news.factory.com.base_recycler.view_holders.article_publication_date;

import android.text.style.TtsSpan;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ArticlePublicationDateData {

    private String publicationDate;

    public ArticlePublicationDateData(String publicationDate) {
        this.publicationDate = publicationDate;
    }


    public String getPublicationDate()  {
        return publicationDate;
    }


}
