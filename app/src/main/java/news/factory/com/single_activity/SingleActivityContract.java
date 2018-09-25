package news.factory.com.single_activity;

public interface SingleActivityContract {

    interface View {

        void setAdapter(Integer pagesNumber);
    }

    interface Presenter {

        void getNumberOfPages();

    }


}
