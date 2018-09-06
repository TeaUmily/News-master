package news.factory.com.main_activity.contract;

public interface MainActivityContract {

    interface View {

        void setAdapter(Integer pages_no);
    }

    interface Presenter {

        void getNumberOfPages();

    }


}
