package at.ac.fhcampuswien.fhmdb;


import at.ac.fhcampuswien.fhmdb.Controller.*;
import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) {


        try {
            DatabaseManager dbm = DatabaseManager.getInstance();

            Parent root = makeRoot();

            Scene scene = new Scene(root, 890, 620);
            scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());
            stage.setTitle("FHMDb");
            stage.setScene(scene);
            stage.show();




        } catch (DatabaseException e) {
            AlertHelper.buildAlert("Database Error", e.getMessage());
        } catch (MovieApiException e) {
            AlertHelper.buildAlert("MovieApi Error", "Likely missing internet connection, or address unreachable \n" + e.getMessage());
        }

    }

    public static Parent makeRoot() throws MovieApiException, DatabaseException {

        ControllerFactory factory = new ControllerFactory();
        FXMLLoader sceneLoader = new FXMLLoader(FhmdbApplication.class.getResource( "base.fxml"));
        FXMLLoader homeLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        FXMLLoader watchlistLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view-watchlist.fxml"));
        FXMLLoader infoLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-info.fxml"));
        ControllerScene sceneController = new ControllerScene();
        ControllerBaseHome homeController = new ControllerBaseHome();
        ControllerBaseWatchlist watchlistController = new ControllerBaseWatchlist();
        sceneLoader.setControllerFactory(factory);
        homeLoader.setControllerFactory(factory);
        watchlistLoader.setControllerFactory(factory);
        infoLoader.setControllerFactory(factory);




        homeController.tab2 = watchlistController;

        homeLoader.setController(homeController);
        watchlistLoader.setController(watchlistController);


        try{
            Tab home = homeLoader.load();
            Tab watchlist = watchlistLoader.load();
            Tab info = infoLoader.load();

            sceneLoader.setController(sceneController);
            Parent root = sceneLoader.load();

            sceneController.tabPane.getTabs().add(home);
            sceneController.tabPane.getTabs().add(watchlist);
            sceneController.tabPane.getTabs().add(info);


            return root;


        } catch (IOException e) {
            AlertHelper.buildAlert("Error loading files", e.getMessage());
            return new Parent() {
            };
        }

    }

    public static void main(String[] args) {

        launch();
    }
}