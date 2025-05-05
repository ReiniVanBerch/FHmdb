package at.ac.fhcampuswien.fhmdb.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class ControllerScene {
    @FXML
    public TabPane tabPane;

    public ControllerScene(){
        tabPane = new TabPane();
    }
}
