package ch.fhnw.depa.a01;

@FunctionalInterface
public interface ColorObserver {
    void update( int red, int geen, int blue);
}