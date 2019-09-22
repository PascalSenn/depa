package ch.fhnw.depa.a01.controls;

import ch.fhnw.depa.a01.ObservableColor;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BrightnessControls extends VBox {
    private ObservableColor color;
    private Button darkerButton;
    private Button brighterButton;

    public BrightnessControls(ObservableColor color) {
        this.color = color;

        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        darkerButton = new Button("Darker");
        brighterButton = new Button("Brigther");

        darkerButton.setOnAction(x -> color.darker().notifyObservers());
        brighterButton.setOnAction(x -> color.brighter().notifyObservers());
    }

    private void layoutControls() {
        getChildren().addAll(darkerButton, brighterButton);
    }

}