package news.factory.com.base_interactor;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class DisposableManager {

        private CompositeDisposable compositeDisposable;

        public DisposableManager() {
            this.compositeDisposable = new CompositeDisposable();
        }

        public void add(Disposable disposable) {
            compositeDisposable.add(disposable);
        }

        public void clear() {
            compositeDisposable.clear();
        }

    }


