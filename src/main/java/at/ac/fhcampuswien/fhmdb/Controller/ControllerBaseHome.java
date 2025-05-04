package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.AlertHelper;
import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class ControllerBaseHome extends ControllerBase {

    @FXML
    public JFXListView movieListView;


    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXComboBox releaseYearComboBox;

    @FXML
    public JFXComboBox ratingComboBox;

    public ControllerBaseWatchlist tab2;

    public ControllerBaseHome(){
        super();




        clickEventHandler = (clickedItem) ->
        {
            if(clickedItem instanceof MovieEntity movie){
                WatchlistMovieEntity watchlistMovieEntity = new WatchlistMovieEntity(movie.getApiId());


                try {
                    WatchlistRepository repository = new WatchlistRepository();
                    repository.addToWatchlist(watchlistMovieEntity);

                } catch (DatabaseException e) {
                    AlertHelper.buildAlert("Database Error", e.getMessage());
                }
            } else{
                System.out.println(clickedItem.getClass());
            }
        };
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        observableMovies.clear();
        observableMovies.addAll(allMovies);
        sortAscending(observableMovies);



        initializeUI(this.clickEventHandler);
    }

    public void initializeUI(ClickEventHandler clickEventHandler){
        super.initializeUI(clickEventHandler);

        sortBtn.setText("Sort (desc)");

        sortBtn.setOnAction(actionEvent -> sort());
        searchBtn.setOnAction(actionEvent -> searchBtnClicked());

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view

        movieListView.setCellFactory(movieListView -> new MovieCell(clickEventHandler)); // use custom cell factory to display data


        if(releaseYearComboBox != null) {
            releaseYearComboBox.getItems().add("all release years");

            Integer[] years = new Integer[75];
            for (int i = 0; i < years.length; i++) {
                years[i] = 1950 + i;
            }

            releaseYearComboBox.getItems().addAll(years);
            releaseYearComboBox.setPromptText("Filter by release year");
        }
        if(ratingComboBox != null) {
            //ratings button
            ratingComboBox.getItems().add("all ratings");
            Integer[] ratings = new Integer[11];
            for (int i = 0; i < ratings.length; i++) {
                ratings[i] = i;
            }
            ratingComboBox.getItems().addAll(ratings);

            ratingComboBox.setPromptText("Filter by ratings");
        }
        if(genreComboBox != null) {
            Genre[] genres = Genre.values();
            genreComboBox.getItems().add("all genres");
            genreComboBox.getItems().addAll(genres);
            genreComboBox.setPromptText("Filter by Genre");

        }
    }
    public void searchBtnClicked(){
        try {


            MovieAPI api = new MovieAPI();

            String title, genre;
            int releaseYear;
            double rating;

            title = searchField.getText();

            Object g = genreComboBox.getSelectionModel().getSelectedItem();
            if(g != null){
                genre = g.toString();
                if(genre.toLowerCase() == "all genres"){genre = null;}
            }
            else {genre = null;}


            try{releaseYear = (int) releaseYearComboBox.getSelectionModel().getSelectedItem();}
            catch (Exception e) {releaseYear = 0;}

            try{rating = ((int) ratingComboBox.getSelectionModel().getSelectedItem());}
            catch (Exception e) {
                System.out.println(e);
                rating = 0;}

            List<MovieEntity> movies = api.getMovies(title, genre, releaseYear, rating);
            observableMovies.clear();
            observableMovies.addAll(movies);

            dbm.getMovieDao().clearObjectCache();
            dbm.getMovieDao().create(movies);

        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }


}