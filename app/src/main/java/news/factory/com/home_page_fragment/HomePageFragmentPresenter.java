package news.factory.com.home_page_fragment;



import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import news.factory.com.base.base_interactor.InteractorWrapper;
import news.factory.com.base.base_recycler.RecyclerWrapper;
import news.factory.com.base.base_recycler.adapter.RecyclerAdapter;
import news.factory.com.helpers.listeners.NetworkResponseListener;
import news.factory.com.helpers.resources_provider.ResourcesProviderImpl;
import news.factory.com.interaction.home_screen_interactor.HomeScreenInteractor;
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
      HomePageData data = new HomePageData();
        recyclerAdapterlazy.get().addItems(getMappedList(data));
    }


    @Override
    public void onSuccess(InteractorWrapper callback) {
        HomePageData data = (HomePageData) callback.getData();
        recyclerAdapterlazy.get().addItems(getMappedList(data));
    }

    private List<RecyclerWrapper> getMappedList(HomePageData data) {

        List<RecyclerWrapper> recyclerWrappers = new ArrayList<>();

        recyclerWrappers.add(new RecyclerWrapper(RecyclerWrapper.TYPE_HOME_PAGE_HEADER));
        recyclerWrappers.add(new RecyclerWrapper(RecyclerWrapper.TYPE_HOME_PAGE_CATEGORY));
        //recyclerWrappers.add(new RecyclerWrapper(RecyclerWrapper.TYPE_ARTICLE_CATEGORIES));

        return recyclerWrappers;
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
