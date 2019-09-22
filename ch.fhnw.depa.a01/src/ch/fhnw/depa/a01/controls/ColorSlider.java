package ch.fhnw.depa.a01.controls;

import java.util.function.Consumer;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ColorSlider extends HBox {

    private Slider scrollbar;
    private TextField textField;
    private TextField textFieldHex;
    private Consumer<Integer> changeHandler;

    public ColorSlider(Consumer<Integer> changeHandler) {
        this.changeHandler = changeHandler;
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {

        scrollbar = new Slider();
        textField = new NumberTextField();
        textFieldHex = new NumberTextField();

    }

    private void layoutControls() {
        this.setSpacing(0);

        this.getChildren().addAll(scrollbar, textField, textFieldHex);

        scrollbar.setMax(255);
        scrollbar.setMin(0);
        scrollbar.valueProperty().addListener((o, old, n) -> changeHandler.accept(n.intValue()));

        textField.textProperty().addListener((o, old, n) -> changeHandler.accept(Integer.valueOf(n)));
    }

    public void setColor(int color) {
        this.scrollbar.valueProperty().set(color);
        this.textField.textProperty().set(Integer.toString(color));
        this.textFieldHex.textProperty().set(Integer.toString(color, 16));
    }

}