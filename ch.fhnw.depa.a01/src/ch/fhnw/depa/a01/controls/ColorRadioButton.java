package ch.fhnw.depa.a01.controls;

import ch.fhnw.depa.a01.ObservableColor;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

class ColorRadioButton extends RadioButton {

    private ObservableColor observableColor;
    private Color color;

    public ColorRadioButton(ObservableColor observableColor, String name, Color color, ToggleGroup toggleGroup) {
        this.observableColor = observableColor;
        this.color = color;
        this.setText(name);
        this.setToggleGroup(toggleGroup);
        this.selectedProperty().addListener(this::handleSelectionChange);
        observableColor.attachObserver(this::handleColorChange);
    }

    public void handleSelectionChange(ObservableValue<? extends Boolean> observable, Boolean oldValue,
            Boolean newValue) {
        if (newValue.booleanValue()) {
            observableColor.color(color).notifyObservers();

        }
    }

    public void handleColorChange(int red, int green, int blue) {
        this.setSelected(Color.rgb(red, green, blue).equals(color));
    }

}