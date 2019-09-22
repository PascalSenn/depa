package ch.fhnw.depa.a01.menu;

import ch.fhnw.depa.a01.ObservableColor;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;

public class ColorMenu extends Menu {

    public ColorMenu(ObservableColor color) {
        this.setText("Attributes");
        this.getItems().add(new ColorMenuItem(color, "red", Color.RED));
        this.getItems().add(new ColorMenuItem(color, "blue", Color.BLUE));
        this.getItems().add(new ColorMenuItem(color, "green", Color.LIME));
        this.getItems().add(new ColorMenuItem(color, "yellow", Color.YELLOW));
        this.getItems().add(new ColorMenuItem(color, "orange", Color.ORANGE));
        this.getItems().add(new ColorMenuItem(color, "cyan", Color.CYAN));
        this.getItems().add(new ColorMenuItem(color, "black", Color.BLACK));

    }
}