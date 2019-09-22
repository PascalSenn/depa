package ch.fhnw.depa.a01;

import ch.fhnw.depa.a01.menu.MainMenuBar;
import ch.fhnw.depa.a01.views.ApplicationUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Startet die Anwendung.
 *
 */
public final class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ObservableColor color = new ObservableColor();
        PresentationModel pm = new PresentationModel(color);
        MainMenuBar mb = new MainMenuBar(color);
        Parent rootPanel = new ApplicationUI(pm, mb);
        
        Scene scene = new Scene(rootPanel);
        
        stage.setScene(scene);
        color.notifyObservers();
        stage.show();
    }

    /**
     * Einstiegspunkt in die Anwendung. Ruft den JavaFX Launcher auf.
     * 
     * @param args Der String Array mit den Args der Anwendung
     */
    public static void main(String[] args) {
        launch(args);
    }
}