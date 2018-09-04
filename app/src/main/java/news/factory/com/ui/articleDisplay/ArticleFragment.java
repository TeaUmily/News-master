package news.factory.com.ui.articleDisplay;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.App;
import news.factory.com.R;
import news.factory.com.model.Article;
import news.factory.com.model.Content;
import news.factory.com.presentation.ArticlePresenter;
import news.factory.com.ui.adapter.RecyclerViewAdapter;

public class ArticleFragment extends Fragment implements ArticleDisplayContract.View{


    @BindView(R.id.recyclerView_article)
    RecyclerView mRecyclerView;

    private ArticleDisplayContract.Presenter mPresenter;
    private RecyclerViewAdapter mAdapter;

    public static ArticleFragment newInstance() {
        ArticleFragment fragment = new ArticleFragment();
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

        mPresenter = new ArticlePresenter();
        mPresenter.setView(this);

        mAdapter = new RecyclerViewAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getArticle();
    }

    @Override
    public void showArticle(Article mArticle) {
        mAdapter.addContents(mArticle.getContent());
    }



}
