package news.factory.com.mainActivity.contract;

public interface MainActivityContract {

    interface View {

        void setAdapter(Integer pages_no);
    }

    interface Presenter {

        void getNumberOfPages();

    }


}
