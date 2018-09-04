package news.factory.com.ui.mainActivity;

import android.support.v4.app.FragmentManager;

import news.factory.com.ui.adapter.CustomViewPagerFragmentAdapter;

public interface MainActivityContract {

    interface View {

        void setAdapterToViewPager(CustomViewPagerFragmentAdapter adapter);
    }

    interface Presenter {

        void setAdapter(FragmentManager supportFragmentManager);

    }


}
