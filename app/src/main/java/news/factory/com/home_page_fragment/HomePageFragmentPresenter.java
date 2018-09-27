package news.factory.com.home_page_fragment;



import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.base.base_recycler.view_holders.home_news_categories.NewsCategoriesData;
import news.factory.com.base.base_recycler.view_holders.home_page.HomePageHeaderData;
import news.factory.com.base.base_recycler.view_holders.home_page_categories.HomePageCategoryNameData;
import news.factory.com.constants.Constants;
import news.factory.com.helpers.listeners.NetworkResponseListener;
import news.factory.com.helpers.resources_provider.ResourcesProviderImpl;
import news.factory.com.interaction.home_screen_interactor.HomeScreenInteractor;
import news.factory.com.model.Articles;
import news.factory.com.model.HomePageArticles;
import news.factory.com.model.HomePageData;

public class HomePageFragmentPresenter implements HomePageFragmentContract.Presenter, NetworkResponseListener {

  private HomeScreenInteractor interactor;
  private HomePageFragmentContract.View homeFragmentView;

  private ResourcesProviderImpl context;

  private Lazy<RecyclerAdapter> recyclerAdapterlazy;

  @Inject
  public HomePageFragmentPresenter (HomePageFragmentContract.View homeFragmentView, HomeScreenInteractor interactor, ResourcesProviderImpl context, Lazy<RecyclerAdapter> adapterLazy){
      this.homeFragmentView = homeFragmentView;
      this.interactor = interactor;
      this.context = context;
      this.recyclerAdapterlazy = adapterLazy;
  }

    public void getHomePage() {
      interactor.getHomeScreenArticles(this, Constants.TOKEN, Constants.INDEX);
    }

    @Override
    public void onSuccess(InteractorWrapper callback) {
        List<HomePageArticles> dataList = (List<HomePageArticles>) callback.getData();
        recyclerAdapterlazy.get().addItems(getMappedList(dataList));
    }

    private List<RecyclerWrapper> getMappedList(List<HomePageArticles> data) {

        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();

        recyclerWrappers.add(new RecyclerWrapper(new HomePageHeaderData(data.get(0).getArticles()), RecyclerWrapper.TYPE_HOME_PAGE_HEADER));

        for (int i=1; i<data.size(); i++){
            recyclerWrappers.add(new RecyclerWrapper(new HomePageCategoryNameData(data.get(i).getName()),RecyclerWrapper.TYPE_HOME_PAGE_CATEGORY));

            recyclerWrappers.add(new RecyclerWrapper(new NewsCategoriesData(data.get(i).getArticles()), RecyclerWrapper.TYPE_HOME_PAGE_NEWS_RECYCLER));

            recyclerWrappers.add(new RecyclerWrapper(RecyclerWrapper.TYPE_HOME_PAGE_ALL_ARTICLES));
        }

        return recyclerWrappers;
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
