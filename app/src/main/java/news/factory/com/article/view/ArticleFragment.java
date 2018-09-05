package news.factory.com.article.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.article.contract.ArticleDisplayContract;
import news.factory.com.article.model.articleListItem.ArticleListItem;
import news.factory.com.constants.Constants;
import news.factory.com.article.presenter.ArticlePresenter;
import news.factory.com.article.adapter.RecyclerViewAdapter;

public class ArticleFragment extends Fragment implements ArticleDisplayContract.View{


    @BindView(R.id.recyclerView_article)
    RecyclerView mRecyclerView;

    @BindView(R.id.articleTitle_textView)
    TextView mTitle;

    private ArticleDisplayContract.Presenter mPresenter;
    private RecyclerViewAdapter mAdapter;


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

        mPresenter = new ArticlePresenter(this);

        mAdapter = new RecyclerViewAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        getArticle();

    }

    private void getArticle() {
        String articleToDisplay = getArguments().getString(Constants.ARTICLE_PAGE_NUMBER);
        mPresenter.getArticle(articleToDisplay);
    }


    @Override
    public void showArticle(List<ArticleListItem> mArticleListItems) {

        mAdapter.addItems(mArticleListItems);
    }


}
