package news.factory.com.base_recycler;

import news.factory.com.R;

public class RecyclerWrapper {

    public static final int TYPE_TITLE = R.layout.cell_article_title;
    public static final int TYPE_TEXT = R.layout.cell_article_text;
    public static final int TYPE_IMAGE = R.layout.cell_article_image;
    public static final int TYPE_FEATURED_IMAGE = R.layout.cell_article_featured_image;
    public static final int TYPE_UPPER_TITLE = R.layout.cell_article_upper_title;
    public static final int TYPE_AUTHOR = R.layout.cell_article_author_shares;
    public static final int TYPE_PUBLICATION_DATE = R.layout.cell_article_publication_date;
    public static final int TYPE_PAGE_INDICATOR = R.layout.cell_page_indicator;
    public static final int TYPE_ARTICLE_CATEGORIES = R.layout.cell_article_categories;
    public static final int TYPE_ARTIClE_ITEM = R.layout.cell_article_item;

    private Object data;
    private int type;

    public RecyclerWrapper(int type) {
        this.type = type;
    }

    public RecyclerWrapper(Object data, int type) {
        this.data = data;
        this.type = type;
    }

    public Object getData() {
        return data;
    }
    public int getType() {
        return type;
    }


}