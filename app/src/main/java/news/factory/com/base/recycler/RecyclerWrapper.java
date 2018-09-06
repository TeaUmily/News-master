package news.factory.com.base.recycler;

import news.factory.com.R;

public class RecyclerWrapper {

    public static final int TYPE_TITLE = R.layout.cell_article_title;
    public static final int TYPE_TEXT = R.layout.cell_article_text;
    public static final int TYPE_IMAGE = R.layout.cell_article_image;
    public static final int TYPE_FEATURED_IMAGE = R.layout.cell_article_featured_image;

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
