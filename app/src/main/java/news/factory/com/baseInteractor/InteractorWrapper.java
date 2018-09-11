package news.factory.com.baseInteractor;

public class InteractorWrapper {

    private Object data;

    public InteractorWrapper(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
