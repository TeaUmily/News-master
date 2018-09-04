package news.factory.com.ui.mainActivity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;

import news.factory.com.presentation.MainActivityPresenter;
import news.factory.com.ui.adapter.CustomViewPagerFragmentAdapter;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View{


    @BindView(R.id.main_activity_view_pager)
    ViewPager mViewPager;


    private MainActivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainActivityPresenter(this);

        mPresenter.setAdapter(getSupportFragmentManager());
    }

    @Override
    public void setAdapterToViewPager(CustomViewPagerFragmentAdapter adapter) {
        mViewPager.setAdapter(adapter);
    }
}
