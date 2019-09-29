import java.util.List;

interface Observer<T> {
    void update(Observable<T> observer, T val);

}

public interface Observable<T>  { 
    T getValue();

    default void attachObserver(Observer<T> observer) {
        synchronized (this) {
            getObservers().add(observer);
        }
    }

    default void removeObserver(Observer<T> observer) {
        synchronized (this) {
            getObservers().remove(observer);
        }
    }

    default void notifyObservers() {
        synchronized (this) {
            for (var o : getObservers()) {
                o.update(this, getValue());
            }
        }
    }
}