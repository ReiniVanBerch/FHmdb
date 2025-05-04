package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.Controller.ControllerBaseHome;
import at.ac.fhcampuswien.fhmdb.Controller.ControllerBaseWatchlist;
import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader base = new FXMLLoader(FhmdbApplication.class.getResource("base.fxml"));
        Parent root = base.load();

        TabPane tabPane = (TabPane) root.lookup("#tabPane");
        /*
        FXMLLoader homeLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        homeLoader.setController(new ControllerBaseHome());
        Tab home = new Tab("Home", homeLoader.load());

        FXMLLoader watchlistLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        watchlistLoader.setController(new ControllerBaseWatchlist());
        Tab watchlist = new Tab("Watchlist", watchlistLoader.load());


        tabPane.getTabs().add(home);
        tabPane.getTabs().add(watchlist);
        */

        try {
            MovieAPI api = new MovieAPI();

            //UUID uuid = UUID.fromString("81d317b0-29e5-4846-97a6-43c07f3edf4a");
            //String response = example.getMovie(uuid);
            //String response = example.getMovies().get(0).toString();
            ;


            DatabaseManager dbm = new DatabaseManager();
            dbm.getMovieDao().create(api.getMovies());

            Scene scene = new Scene(root, 890, 620);
            scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());
            stage.setTitle("FHMDb");
            stage.setScene(scene);
            stage.show();

        } catch (DatabaseException e) {
            AlertHelper.buildAlert("Database Error", e.getMessage());
        } catch (IOException e) {
            AlertHelper.buildAlert("IOException Error", e.getMessage());
        } catch (SQLException e) {
            AlertHelper.buildAlert("SQLException Error", e.getMessage());
        }

    }

    public static void main(String[] args) {
        //List<Movie> movies = Movie.initializeMovies();
        //System.out.println(movies.get(0).toString());;
        launch();
    }
}