package news.factory.com.home_screen.home_activity;


import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.BaseActivity;
import news.factory.com.home_screen.home_activity.adapter.HomePagerAdapterImpl;
import news.factory.com.model.HomeMenuBottomItem;

public class HomeActivity extends BaseActivity implements HomeActivityContract.View {

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.tablayout_home_screen)
    TabLayout tabLayout;

    @BindView(R.id.viewpager_home_screen)
    ViewPager viewPager;

    @Inject
    protected HomeActivityContract.Presenter presenter;

    @Inject
    protected HomePagerAdapterImpl adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ButterKnife.bind(this);

        presenter.getBottomMenuTitles();

    }


    private void setTabLayoutView() {
        LinearLayout tabListed = ((LinearLayout)tabLayout.getChildAt(0));
        for(int position = 0; position<tabListed.getChildCount(); position++) {
            LinearLayout item=((LinearLayout) tabListed.getChildAt(position));
            item.setRotationX(180);
        }
    }


    @Override
    public void setHomeScreenView(List<HomeMenuBottomItem> list) {

        adapter.setSize(list.size());
        viewPager.setAdapter(adapter);

        adapter.setDataList(list);
        tabLayout.setupWithViewPager(viewPager);

        setTabLayoutView();

        }

}
