package news.factory.com.articleRepository;


import java.util.ArrayList;
import java.util.List;


import news.factory.com.model.Article;

public class AllArticles {

    private static AllArticles sRepository = null;

    private ArrayList<Article> mArticles;

    public AllArticles() {
        this.mArticles = new ArrayList<>(3);
        this.mArticles.add(new Article());
        this.mArticles.add(new Article());
        this.mArticles.add(new Article());
    }

    public static synchronized AllArticles getInstance(){
        if(sRepository == null){
            sRepository = new AllArticles();
        }
        return sRepository;
    }


    public List<Article> getAllArticles(){
        return mArticles;
    }

}
