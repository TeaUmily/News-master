package news.factory.com.base.base_recycler.view_holders.home_page_categories;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import news.factory.com.R;

public class HomeCategoriesHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.category_name_home_page)
    TextView categoryName;

    public HomeCategoriesHolder(View itemView) {
        super(itemView);
    }

    public void onBind(int position) {
        categoryName.setText("Vijesti");
    }
}
