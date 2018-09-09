package news.factory.com.base.recycler.view_holders.article_author_shares;

public class ArticleAuthorAndSharesData {

    private String author;
    private String numberOfShares;

    public ArticleAuthorAndSharesData(String author, String numberOfShares) {
        this.author = author;
        this.numberOfShares = numberOfShares;
    }

    public String getAuthor() {
        return author;
    }


    public String getNumberOfShares() {
        return numberOfShares;
    }
}
