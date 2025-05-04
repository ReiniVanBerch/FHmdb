package at.ac.fhcampuswien.fhmdb;

import javafx.scene.control.Alert;

public class AlertHelper {
    public static void buildAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
