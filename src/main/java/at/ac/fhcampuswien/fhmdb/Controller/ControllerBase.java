package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.AlertHelper;
import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieRepository;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public abstract class ControllerBase implements Initializable {

    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;



    @FXML
    public JFXButton sortBtn;

    protected ClickEventHandler clickEventHandler;
    protected DatabaseManager dbm;

    public List<MovieEntity> allMovies;

    protected final ObservableList<MovieEntity> observableMovies = FXCollections.observableArrayList();
    protected final ObservableList<MovieEntity> observableWatchlistMovies = FXCollections.observableArrayList();

    public ControllerBase() {
        try {
            dbm = new DatabaseManager();
            allMovies = dbm.getMovieDao().queryForAll();






        } catch (DatabaseException e) {
            AlertHelper.buildAlert("Database Error", e.getMessage());

        } catch (SQLException e) {
            AlertHelper.buildAlert("SQL Error", e.getMessage());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeLogic();
        initializeUI(this.clickEventHandler, observableMovies);
    }

    public void initializeLogic() {
        System.out.println("Init Logic");
        observableMovies.clear();
        observableMovies.addAll(allMovies);
        sortAscending(observableMovies);


    }

    public void initializeUI(ClickEventHandler clickEventHandler, ObservableList<MovieEntity> observableMovies) {




        //set initial sort button text
        sortBtn.setText("Sort (desc)");

        sortBtn.setOnAction(actionEvent -> sort());
        searchBtn.setOnAction(actionEvent -> searchBtnClicked());
        //watchListBtn.setOnAction(actionEvent -> watchListBtnClicked());
    }

    public void searchBtnClicked(){
        try {


            MovieAPI api = new MovieAPI();

            String title, genre;
            int releaseYear;
            double rating;

            title = searchField.getText();

//            Object g = genreComboBox.getSelectionModel().getSelectedItem();
//            if(g != null){
//                genre = g.toString();
//                if(genre.toLowerCase() == "all genres"){genre = null;}
//            }
//            else {genre = null;}
//
//
//            try{releaseYear = (int) releaseYearComboBox.getSelectionModel().getSelectedItem();}
//            catch (Exception e) {releaseYear = 0;}
//
//            try{rating = ((int) ratingComboBox.getSelectionModel().getSelectedItem());}
//            catch (Exception e) {
//                System.out.println(e);
//                rating = 0;}

            //observableMovies.clear();
            //observableMovies.addAll(dbm.getMovieDao().queryForAll());
            //api.getMovies(title, genre, releaseYear, rating);
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }

    public void sort() {
        if(sortBtn.getText().equals("Sort (asc)")) {
            sortAscending(observableMovies);
            sortBtn.setText("Sort (desc)");
        } else {
            sortDescending(observableMovies);
            sortBtn.setText("Sort (asc)");
        }
    }

    public void sortAscending(ObservableList<MovieEntity> list) {
        list.sort(Comparator.comparing(MovieEntity::getTitle));
    }

    public void sortDescending(ObservableList<MovieEntity> list) {
        list.sort(Comparator.comparing(MovieEntity::getTitle).reversed());
    }



    /*
    //still to do return most popular actor of sent movie
    public String getMostPopularActor(List<MovieEntity> movies){
        String actor = movies.stream()
                .filter(movie -> movie.getMainCast() != null)
                .flatMap(movie -> movie.getMainCast().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
        return actor;
    }

    //filtert auf den längsten Titel der übergebenen Filme und gibt die Anzahl der Buchstaben des Titels zurück
    public int getLongestMovieTitle(List<MovieEntity> movies){
        return movies.stream()
                .mapToInt(movie -> movie.getTitle().length())
                .max()
                .orElse(0);
    }

    //gibt die Anzahl der Filme eines bestimmten Regisseurs zurück.
    public long countMoviesFrom(List<MovieEntity> movies, String director){
        return movies.stream()
                .filter(movie -> movie.getDirectors() != null)
                .filter(movie -> movie.getDirectors().contains(director))
                .count();

    }

    //gibt jene Filme zurück, die zwischen zwei gegebenen Jahren veröffentlicht wurden.
    public List<MovieEntity> getMoviesBetweenYears(List<MovieEntity> movies, int startYear, int endYear){

        return movies.stream()
                .filter(movie -> movie.getReleaseYear() >= startYear && movie.getReleaseYear() <= endYear)
                .collect(Collectors.toList());
    }


    public List<Movie> filterGenre(Object genre, List<Movie> moviesList) {
        System.out.println(genre);
        if (genre == null || genre.toString().equals("all genres")) {
        return moviesList;
        } else {
            return moviesList.stream()
                    .filter(movie -> movie.getGenres().contains(genre))
                    .toList();
        }
    }

    public List<Movie> filterSearchField(String searchQuery, List<Movie> moviesList) {
        if (searchQuery == null || searchQuery.isEmpty()) {
            return moviesList;
        } else {
            return moviesList.stream().filter(movie ->
                    movie.getTitle().toLowerCase().contains(searchQuery) ||
                    movie.getDescription().toLowerCase().contains(searchQuery))
                    .toList();
        }
    }

    public List<Movie> getFilteredMovies(Object genre) {
        String searchQuery = searchField.getText().toLowerCase();
        List<Movie> filteredList = new ArrayList<>(allMovies);
        filteredList = filterGenre(genre, filteredList);
        filteredList = filterSearchField(searchQuery, filteredList);
        return filteredList;
    }

    public void updateUIAfterFilter() {
        Object genre = genreComboBox.getSelectionModel().getSelectedItem();
        List<Movie> filteredMovies = getFilteredMovies(genre);
        observableMovies.clear();
        observableMovies.addAll(filteredMovies);
        if(sortBtn.getText().equals("Sort (asc)")) {
            sortDescending(observableMovies);

        } else {
            sortAscending(observableMovies);
        }
        movieListView.refresh();
    }

    public void searchBtnClicked() {
        updateUIAfterFilter();
    }

    public ObservableList<Movie> getObservableMovies() {
        return observableMovies;
    }
    */


}
