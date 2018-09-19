package news.factory.com.article_categories_fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


import dagger.android.support.AndroidSupportInjection;
import news.factory.com.R;
import news.factory.com.base_recycler.DividerItemDecoration;

import news.factory.com.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.constants.Constants;

public class CategoriesFragment extends Fragment implements CategoriesContract.View {

    @BindView(R.id.recyclerView_article)
    RecyclerView recyclerView;

    @Inject
    protected CategoriesContract.Presenter presenter;

    @Inject
    protected RecyclerAdapterImpl adapter;

    public static CategoriesFragment newInstance(int page) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.CATEGORIES_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        getArticles();
    }

    private void getArticles() {
      int  articleToDisplay = getArguments().getInt(Constants.CATEGORIES_PAGE_NUMBER);

        switch (articleToDisplay){
            case 1 : presenter.getMostPopularArticles();
            break;
            case 2 : presenter.getMostReadArticles();
            break;
            case 3 : presenter.getNewestArticles();
            break;
        }

    }

}
