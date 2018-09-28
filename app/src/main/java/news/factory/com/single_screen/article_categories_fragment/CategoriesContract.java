package news.factory.com.single_screen.article_categories_fragment;

public interface CategoriesContract {


    interface View{

    }

    interface Presenter{

        void getArticles(int pageNum);

    }

}
