package news.factory.com.main_activity.contract;

public interface MainActivityContract {

    interface View {

        void setAdapter(Integer pagesNumber);
    }

    interface Presenter {

        void getNumberOfPages();

    }


}
