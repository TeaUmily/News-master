package news.factory.com.header_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import news.factory.com.R;
import news.factory.com.article_fragment.ArticleFragment;
import news.factory.com.base.BaseFragment;
import news.factory.com.constants.Constants;
import news.factory.com.model.Articles;


public class HeaderFragment extends Fragment {


     @BindView(R.id.image_header_home_page)
     ImageView image;

     @BindView(R.id.category_home_header)
      TextView category;


     private static   List<Articles> articlesList;


    public static HeaderFragment newInstance(int position, List<Articles> dataList){
        HeaderFragment fragment = new HeaderFragment();

        articlesList = dataList;

        Bundle data = new Bundle();
        data.putInt(Constants.POSITION, position);
        fragment.setArguments(data);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        int position = this.getArguments().getInt(Constants.POSITION);

        Glide.with(image.getContext()).load(Constants.IMAGE_BASE_URL + articlesList.get(position).getFeaturedImage().getM()).into(image);
        category.setText(articlesList.get(position).getCategory());

    }

}
