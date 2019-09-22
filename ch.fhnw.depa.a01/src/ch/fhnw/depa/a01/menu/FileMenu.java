package ch.fhnw.depa.a01.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class FileMenu extends Menu {
    private MenuItem exit = new MenuItem("Exit");

    public FileMenu() {
        exit.setOnAction(x -> System.exit(1));
        this.setText("File");
        this.getItems().add(exit);

    }
}