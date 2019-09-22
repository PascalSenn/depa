package ch.fhnw.depa.a01.menu;

import ch.fhnw.depa.a01.ObservableColor;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

class ColorMenuItem extends MenuItem {

    public ColorMenuItem(ObservableColor observableColor, String name, Color color) {
        this.setText(name);
        this.setOnAction(x -> observableColor.color(color).notifyObservers());
    }

}