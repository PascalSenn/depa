package ch.fhnw.depa.a01.menu;

import ch.fhnw.depa.a01.ObservableColor;
import javafx.scene.control.MenuBar;

public class MainMenuBar extends MenuBar {

    public MainMenuBar(ObservableColor color) {
        this.getMenus().addAll(new FileMenu(), new ColorMenu(color));
    }

}