package ch.fhnw.depa.a01;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public final class ObservableColor implements ColorObservable {
    private List<ColorObserver> observers = new ArrayList<ColorObserver>();
    private Color color;

    public int getRed() {
        return (int) (color.getRed() * 255);
    }

    public int getBlue() {
        return (int) (color.getBlue() * 255);
    }

    public int getGreen() {
        return (int) (color.getGreen() * 255);
    }

    public Color getColor() {
        return color;
    }

    public ObservableColor color(Color color) {
        this.color = color;
        return this;
    }

    public ObservableColor darker() {
        this.color = color.darker();
        return this;
    }

    public ObservableColor brighter() {
        this.color = color.brighter();
        return this;
    }

    public ObservableColor red(int red) {
        color = Color.rgb(red % 256, getGreen(), getBlue());
        return this;
    }

    public ObservableColor green(int green) {
        color = Color.rgb(getRed(), green % 256, getBlue());
        return this;
    }

    public ObservableColor blue(int blue) {
        color = Color.rgb(getRed(), getGreen(), blue % 256);
        return this;
    }

    public ObservableColor() {
        color = Color.rgb(0, 0, 0);
    }

    @Override
    public void attachObserver(ColorObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(x -> x.update(getRed(), getGreen(), getBlue()));

    }
}