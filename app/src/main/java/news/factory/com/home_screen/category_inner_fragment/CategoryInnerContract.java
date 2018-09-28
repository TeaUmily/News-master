package news.factory.com.home_screen.category_inner_fragment;

public interface CategoryInnerContract {

    interface View {

        void showArticle(String articleId);


    }

    interface Presenter{

        void getNewestArticles( int mainPosition);

        void getMostReadArticles(int mainPosition);

        void openArticle(String articleId);


    }

}
