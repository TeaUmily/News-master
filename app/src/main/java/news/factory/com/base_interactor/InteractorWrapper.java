package news.factory.com.base_interactor;

public class InteractorWrapper {

    private Object data;

    public InteractorWrapper(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
