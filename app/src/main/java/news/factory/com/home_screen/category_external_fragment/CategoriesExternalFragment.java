package news.factory.com.home_screen.category_external_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.factory.com.R;
import news.factory.com.base.BaseFragment;
import news.factory.com.constants.Constants;


public class CategoriesExternalFragment extends BaseFragment {

    @BindView(R.id.category_viewpager)
    ViewPager viewPager;

    @BindView(R.id.tablayout_categories)
    TabLayout tabLayout;

    @Inject
    protected CategoriesPagerAdapter categoriesPagerAdapter;

    public static CategoriesExternalFragment newInstance(int position) {

        Bundle data = new Bundle();
        data.putInt(Constants.POSITION_MAIN_PAGER, position);
        CategoriesExternalFragment fragment = new CategoriesExternalFragment();
        fragment.setArguments(data);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_external, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        int position = this.getArguments().getInt(Constants.POSITION_MAIN_PAGER);

        categoriesPagerAdapter.setSize(2);
        categoriesPagerAdapter.setMainPagerPosition(position);
        viewPager.setAdapter(categoriesPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}