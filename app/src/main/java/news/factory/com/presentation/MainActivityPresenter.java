package news.factory.com.presentation;

import android.support.v4.app.FragmentManager;

import news.factory.com.articleRepository.AllArticles;
import news.factory.com.ui.adapter.CustomViewPagerFragmentAdapter;
import news.factory.com.ui.mainActivity.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mMainActivityView;

    private CustomViewPagerFragmentAdapter mAdapter;

    private AllArticles mAllArticles;

    public MainActivityPresenter(MainActivityContract.View mMainActivityView) {
        this.mMainActivityView = mMainActivityView;
        mAllArticles = AllArticles.getInstance();
    }

    @Override
    public void setAdapter(FragmentManager supportFragmentManager) {
        this.mAdapter = new CustomViewPagerFragmentAdapter(supportFragmentManager);
        mAdapter.setAdapterData(mAllArticles.getAllArticles());
        mMainActivityView.setAdapterToViewPager(mAdapter);

    }

}
