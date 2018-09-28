package news.factory.com.single_screen.article_fragment;

import java.util.List;

import news.factory.com.base.base_recycler.RecyclerWrapper;

public interface ArticleContract {

    interface View {

        void showArticle(List<RecyclerWrapper> article);

    }

    interface Presenter {

        void getArticle(String articleToDisplay);

        String getArticlePageNumber();
    }


}
