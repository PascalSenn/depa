package ch.fhnw.depa.a01.controls;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.depa.a01.ObservableColor;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColorToggleGroup extends VBox {
    private List<ColorRadioButton> colors = new ArrayList<ColorRadioButton>();
    private ToggleGroup toggleGroup = new ToggleGroup();

    public ColorToggleGroup(ObservableColor color) {
        colors.add(new ColorRadioButton(color, "red", Color.RED, toggleGroup));
        colors.add(new ColorRadioButton(color, "blue", Color.BLUE, toggleGroup));
        colors.add(new ColorRadioButton(color, "green", Color.LIME, toggleGroup));
        colors.add(new ColorRadioButton(color, "yellow", Color.YELLOW, toggleGroup));
        colors.add(new ColorRadioButton(color, "orange", Color.ORANGE, toggleGroup));
        colors.add(new ColorRadioButton(color, "cyan", Color.CYAN, toggleGroup));
        colors.add(new ColorRadioButton(color, "black", Color.BLACK, toggleGroup));

        this.getChildren().addAll(colors);
    }

}