package news.factory.com.ui.articleDisplay;

import java.util.List;

import news.factory.com.model.Article;

public interface ArticleDisplayContract {

    interface View {

        void showArticle(Article mArticle);

    }


    interface Presenter {

        void setView(View articleView);

        void getArticle();
    }


}
