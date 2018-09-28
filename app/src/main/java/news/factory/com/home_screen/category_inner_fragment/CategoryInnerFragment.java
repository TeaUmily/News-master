package news.factory.com.home_screen.category_inner_fragment;

import android.content.Intent;
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
import news.factory.com.single_screen.article_fragment.ArticlePresenter;
import news.factory.com.base.BaseFragment;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.constants.Constants;
import news.factory.com.single_screen.single_activity.SingleActivity;


public class CategoryInnerFragment extends BaseFragment implements CategoryInnerContract.View{


    private static final String ACTION_OPEN_ARTICLE = "";

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;


    @Inject
    protected CategoryInnerContract.Presenter presenter;

    @Inject
    protected RecyclerAdapterImpl adapter;


    public static CategoryInnerFragment newInstance(int position, int mainPagerPosition) {
        Bundle data = new Bundle();
        data.putInt(Constants.POSITION, position);
        data.putInt(Constants.POSITION_MAIN_PAGER, mainPagerPosition);
        CategoryInnerFragment fragment = new CategoryInnerFragment();
        fragment.setArguments(data);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_recycler, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        int position = this.getArguments().getInt(Constants.POSITION);
        int mainPosition = this.getArguments().getInt(Constants.POSITION_MAIN_PAGER);


        if (position == 0){
            presenter.getNewestArticles(mainPosition);
        }
        else{
            presenter.getMostReadArticles(mainPosition);
        }

    }

    @Override
    public void showArticle(String articleId) {
        Intent openArticle = new Intent();

        ArticlePresenter.ARTICLE_ID = articleId;

        openArticle.setAction(ACTION_OPEN_ARTICLE);
        openArticle.setClass(getContext(), SingleActivity.class);

        startActivity(openArticle);
    }
}
