package ch.fhnw.depa.a01.views;

import ch.fhnw.depa.a01.PresentationModel;
import ch.fhnw.depa.a01.controls.BrightnessControls;
import ch.fhnw.depa.a01.controls.ColorDisplay;
import ch.fhnw.depa.a01.controls.ColorSlider;
import ch.fhnw.depa.a01.controls.ColorToggleGroup;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Die Klasse die alle Controls enthält (View).
 *
 */
public final class ApplicationUI extends VBox {
    private final PresentationModel model;

    private ColorSlider redColorSlider;
    private ColorSlider blueColorSlider;
    private ColorSlider greenColorSlider;
    private GridPane lowerLayout;
    private ColorDisplay colorDisplay;
    private ColorToggleGroup colorToggleGroup;
    private BrightnessControls brightnessControls;

    /**
     * Erzeugt eine neue View.
     * 
     * @param model Das Presentation Model für diese View
     */
    public ApplicationUI(PresentationModel model, Node... children) {
        super(children);
        this.model = model;

        initializeControls();
        layoutControls();
        attachRules();
    }

    private void initializeControls() {
        redColorSlider = new ColorSlider((red) -> this.model.getColor().red(red).notifyObservers());
        blueColorSlider = new ColorSlider((blue) -> this.model.getColor().blue(blue).notifyObservers());
        greenColorSlider = new ColorSlider((green) -> this.model.getColor().green(green).notifyObservers());
        lowerLayout = new GridPane();
        colorDisplay = new ColorDisplay(this.model.getColor());
        colorToggleGroup = new ColorToggleGroup(this.model.getColor());
        brightnessControls = new BrightnessControls(this.model.getColor());
    }

    private void layoutControls() {
        setSpacing(20);
        colorDisplay.setWidth(100);
        colorDisplay.setHeight(100);
        for (int i = 0; i < 3; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100.0 / 3.0);
            cc.setHgrow(Priority.ALWAYS);
            lowerLayout.getColumnConstraints().add(cc);
        }

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        lowerLayout.getRowConstraints().add(rc);

        lowerLayout.add(new StackPane(colorDisplay), 0, 0);
        lowerLayout.add(new StackPane(colorToggleGroup), 1, 0);
        lowerLayout.add(new StackPane(brightnessControls), 2, 0);
        this.getChildren().addAll(redColorSlider, blueColorSlider, greenColorSlider, lowerLayout);

    }

    private void attachRules() {
        this.model.getColor().attachObserver((red, green, blue) -> redColorSlider.setColor(red));
        this.model.getColor().attachObserver((red, green, blue) -> blueColorSlider.setColor(blue));
        this.model.getColor().attachObserver((red, green, blue) -> greenColorSlider.setColor(green));
    }
}