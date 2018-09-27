package news.factory.com.article_categories_fragment;


import android.os.Bundle;
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
import news.factory.com.base.base_recycler.adapter.RecyclerAdapterImpl;
import news.factory.com.constants.Constants;

public class CategoriesFragment extends BaseFragment implements CategoriesContract.View{


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @Inject
    protected CategoriesContract.Presenter presenter;

    @Inject
    protected RecyclerAdapterImpl adapter;


    public static CategoriesFragment newInstance(int page) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.CATEGORY_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_recycler, container, false);
        return view;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        getArticles();
    }

    private void getArticles() {
        int pageNum = getArguments().getInt(Constants.CATEGORY_PAGE_NUMBER);

        presenter.getArticles(pageNum);
    }


}
