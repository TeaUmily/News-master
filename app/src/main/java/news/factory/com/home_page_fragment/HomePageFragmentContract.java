package news.factory.com.home_page_fragment;

public interface HomePageFragmentContract {

    interface View{

        void showHomePage();
    }

    interface Presenter {

        void getHomePage();

    }
}
