package ch.fhnw.depa.a01;

public interface ColorObservable {
    void attachObserver(ColorObserver observer);

    void notifyObservers();
}