package ch.fhnw.depa.a01.controls;

import ch.fhnw.depa.a01.ObservableColor;
import javafx.scene.shape.Rectangle;

public class ColorDisplay extends Rectangle {
    public ColorDisplay(ObservableColor color) {
        color.attachObserver((r, g, b) -> this.setFill(color.getColor()));
    }
}