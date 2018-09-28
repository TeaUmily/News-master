package news.factory.com.home_screen.home_activity;

import java.util.List;

import news.factory.com.model.HomeMenuBottomItem;

public interface HomeActivityContract {

    interface View{
        void setHomeScreenView(List<HomeMenuBottomItem> list);
    }

    interface Presenter{

        void getBottomMenuTitles();

    }
}
