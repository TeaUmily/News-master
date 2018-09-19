package news.factory.com.article_fragment;


public interface ArticleContract {

    interface View {


    }

    interface Presenter {

        void getArticle(String articleToDisplay);

        String getArticlePageNumber();

    }


}
