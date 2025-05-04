package at.ac.fhcampuswien.fhmdb;


import at.ac.fhcampuswien.fhmdb.Controller.ControllerBase;
import at.ac.fhcampuswien.fhmdb.Controller.ControllerBaseHome;
import at.ac.fhcampuswien.fhmdb.Controller.ControllerBaseWatchlist;
import at.ac.fhcampuswien.fhmdb.Controller.ControllerScene;
import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader base = new FXMLLoader(FhmdbApplication.class.getResource("base.fxml"));
        Parent root = base.load();

        try {



            DatabaseManager dbm = new DatabaseManager();

            Scene scene = new Scene(root, 890, 620);
            scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());
            stage.setTitle("FHMDb");
            stage.setScene(scene);
            stage.show();




        } catch (DatabaseException e) {
            AlertHelper.buildAlert("Database Error", e.getMessage());
        }

    }

    public static void main(String[] args) {

        launch();
    }
}