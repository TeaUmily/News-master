package news.factory.com.article_fragment.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.article_fragment.contract.ArticleDisplayContract;
import news.factory.com.base_recycler.recycler.DividerItemDecoration;
import news.factory.com.base_recycler.recycler.adapter.RecyclerAdapter;
import news.factory.com.base_recycler.recycler.RecyclerWrapper;
import news.factory.com.constants.Constants;
import news.factory.com.article_fragment.presenter.ArticlePresenter;

public class ArticleFragment extends Fragment implements ArticleDisplayContract.View{


    @BindView(R.id.recyclerView_article)
    RecyclerView recyclerView;

    private ArticleDisplayContract.Presenter presenter;
    private RecyclerAdapter adapter;


    public static ArticleFragment newInstance(int articleNumber) {
        Bundle data = new Bundle();
        data.putString(Constants.ARTICLE_PAGE_NUMBER, String.valueOf(articleNumber+1));
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(data);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        presenter = new ArticlePresenter(this);
        adapter = new RecyclerAdapter();


        recyclerView.addItemDecoration(new DividerItemDecoration());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        getArticle();
    }

    private void getArticle() {
        String articleToDisplay = getArguments().getString(Constants.ARTICLE_PAGE_NUMBER);
        presenter.getArticle(articleToDisplay);
    }

    @Override
    public void showArticle(List<RecyclerWrapper> articleList) {

        adapter.addItems(articleList);
    }

    @Override
    public void onDestroy() {
        presenter.clearDisposable();
        super.onDestroy();
    }
}
