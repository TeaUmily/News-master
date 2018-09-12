package news.factory.com.base_interactor;

public class InteractorWrapper {

    private Object data;

    private String type;


    public InteractorWrapper(Object data) {
        this.data = data;
    }

    public InteractorWrapper(Object data, String type) {
        this.data = data;
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public String getType() {
        return type;
    }

}
