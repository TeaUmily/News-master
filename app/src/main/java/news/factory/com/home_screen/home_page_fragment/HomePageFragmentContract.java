package news.factory.com.home_screen.home_page_fragment;

public interface HomePageFragmentContract {

    interface View{

        void showHomePage();

        void openSingleActivity(String articleId);
    }

    interface Presenter {

        void getHomePage();

        void openArticle(String articleId);
    }
}
