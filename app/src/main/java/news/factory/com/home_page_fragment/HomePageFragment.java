package news.factory.com.home_page_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.BaseFragment;
import news.factory.com.base.base_recycler.DividerItemDecoration;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.article_categories.CategoriesPagerAdapterImpl;
import news.factory.com.base.base_recycler.view_holders.home_page.adapter.HeaderHomePagerAdapterImpl;

public class HomePageFragment extends BaseFragment implements HomePageFragmentContract.View {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @Inject
    protected HomePageFragmentContract.Presenter presenter;

    @Inject
    protected RecyclerAdapterImpl adapter;

    @Inject
    protected HeaderHomePagerAdapterImpl pagerAdapter;

    @Inject
    protected CategoriesPagerAdapterImpl categoriesPagerAdapter;


    public static HomePageFragment newInstance (){
        HomePageFragment fragment = new HomePageFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_recycler, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        adapter.setViewPagerAdapter(categoriesPagerAdapter);
        adapter.setHeaderHomePageAdapter(pagerAdapter);

        showHomePage();
    }


    public void showHomePage() {
        presenter.getHomePage();
    }


}
