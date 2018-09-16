package news.factory.com.main_activity.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import news.factory.com.R;
import news.factory.com.main_activity.adapter.ViewPagerAdapter;
import news.factory.com.main_activity.contract.MainActivityContract;
import news.factory.com.main_activity.presenter.MainActivityPresenter;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    @BindView(R.id.main_activity_view_pager)
    ViewPager viewPager;

    @BindView(R.id.floating_forward_button)
    ImageView forwardNav;

    @BindView(R.id.floating_back_button)
    ImageView backwardNav;


    @Inject
    protected ViewPagerAdapter adapter;

    @Inject
    protected MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter.getNumberOfPages();

    }

    @Override
    public void setAdapter(Integer pagesNumber) {
        adapter.setSize(pagesNumber);
        viewPager.setAdapter(adapter);
        setNavigationButtons(viewPager.getCurrentItem(),adapter.getCount());
    }

    @OnPageChange(R.id.main_activity_view_pager)
    public void handleClicks(){
        setNavigationButtons(viewPager.getCurrentItem(),adapter.getCount());
    }

    @OnClick(R.id.floating_back_button)
    public void onBackwardClick(){
        viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }

    @OnClick(R.id.floating_forward_button)
    public void onForwardClick(){
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }

    public void setNavigationButtons(int index, int numOfItems){
        if(numOfItems > 1){
            if (index == 0){
                backwardNav.setVisibility(View.GONE);
                forwardNav.setVisibility(View.VISIBLE);
            }
            else if (index==numOfItems-1){
                backwardNav.setVisibility(View.VISIBLE);
                forwardNav.setVisibility(View.GONE);
            }
            else{
                backwardNav.setVisibility(View.VISIBLE);
                forwardNav.setVisibility(View.VISIBLE);
            }
        }
        else{
            backwardNav.setVisibility(View.GONE);
            forwardNav.setVisibility(View.GONE);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
