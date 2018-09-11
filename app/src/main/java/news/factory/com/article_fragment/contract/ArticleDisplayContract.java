package news.factory.com.article_fragment.contract;

import java.util.List;

import news.factory.com.base.recycler.RecyclerWrapper;
import news.factory.com.baseInteractor.DisposableManager;

public interface ArticleDisplayContract {

    interface View {

        void showArticle(List<RecyclerWrapper> mArticle);

    }


    interface Presenter {

        void getArticle(String articleToDisplay);

        void clearDisposable();
    }


}
