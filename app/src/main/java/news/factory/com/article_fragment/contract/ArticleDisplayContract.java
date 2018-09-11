package news.factory.com.article_fragment.contract;

import java.util.List;

import news.factory.com.base_recycler.recycler.RecyclerWrapper;

public interface ArticleDisplayContract {

    interface View {

        void showArticle(List<RecyclerWrapper> mArticle);

    }


    interface Presenter {

        void getArticle(String articleToDisplay);

        void clearDisposable();
    }


}
