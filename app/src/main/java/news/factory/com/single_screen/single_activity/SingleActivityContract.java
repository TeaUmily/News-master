package news.factory.com.single_screen.single_activity;

public interface SingleActivityContract {

    interface View {

        void setAdapter(Integer pagesNumber);
    }

    interface Presenter {

        void setArticleOnScreen();


    }


}
