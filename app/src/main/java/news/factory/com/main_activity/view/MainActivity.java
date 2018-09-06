package news.factory.com.main_activity.view;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;

import news.factory.com.main_activity.presenter.MainActivityPresenter;
import news.factory.com.main_activity.adapter.CustomViewPagerFragmentAdapter;
import news.factory.com.main_activity.contract.MainActivityContract;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    @BindView(R.id.main_activity_view_pager)
    ViewPager viewPager;

    private CustomViewPagerFragmentAdapter mAdapter;

    private MainActivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainActivityPresenter(this);

        mPresenter.getNumberOfPages();
    }

    @Override
    public void setAdapter(Integer pages_no) {
        this.mAdapter = new CustomViewPagerFragmentAdapter(getSupportFragmentManager());
        mAdapter.setSize(pages_no);
        viewPager.setAdapter(mAdapter);
    }
}
