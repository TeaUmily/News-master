package news.factory.com.base_recycler.recycler.view_holders.article_page_indicator;

public class ArticlePageIndicatorData {

    private String pageIndicator;
    private String numberOfPages;


    public ArticlePageIndicatorData(String articlePageNumber, String pageCounter) {
        this.pageIndicator = pageCounter;
        this.numberOfPages = articlePageNumber;
    }

    public String getPageIndicator() {
        return pageIndicator;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }
}
