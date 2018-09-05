package news.factory.com.article.contract;

import java.util.List;

import news.factory.com.article.model.articleListItem.ArticleListItem;

public interface ArticleDisplayContract {

    interface View {

        void showArticle(List<ArticleListItem> mArticle);

    }


    interface Presenter {

        void getArticle(String articleToDisplay);
    }


}
