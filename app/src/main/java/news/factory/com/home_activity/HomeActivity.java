package news.factory.com.home_activity;


import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.widget.LinearLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.BaseActivity;
import news.factory.com.home_activity.adapter.HomePagerAdapterImpl;

public class HomeActivity extends BaseActivity implements HomeActivityContract.View {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.tablayout_home_screen)
    TabLayout tabLayout;

    @BindView(R.id.viewpager_home_screen)
    ViewPager viewPager;

    @Inject
    protected HomePagerAdapterImpl adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ButterKnife.bind(this);

        setTabLayoutView();
        adapter.setSize(8);
        viewPager.setAdapter(adapter);


    }


    private void setTabLayoutView() {
        LinearLayout tabListed = ((LinearLayout)tabLayout.getChildAt(0));
        for(int position = 0;position<tabListed.getChildCount();position++) {
            LinearLayout item=((LinearLayout) tabListed.getChildAt(position));
            item.setRotationX(180);
        }
    }


}
