package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.AlertHelper;
import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieRepository;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
    public TabPane tabPane;


    @FXML
    public JFXButton sortBtn;

    protected ClickEventHandler clickEventHandler;
    protected DatabaseManager dbm;

    public List<MovieEntity> allMovies;

    protected final ObservableList<MovieEntity> observableMovies = FXCollections.observableArrayList();

    public ControllerBase() {
        try {
            try {
                dbm = DatabaseManager.getInstance();
                allMovies = dbm.getMovieDao().queryForAll();
            } catch (SQLException e) {
                throw new MovieApiException(e);
            }
        }  catch (MovieApiException e) {
            AlertHelper.buildAlert("MovieAPI Error", e.getMessage());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        initializeUI(this.clickEventHandler);

    }



    public void initializeUI(ClickEventHandler clickEventHandler) {




        //set initial sort button text

        //watchListBtn.setOnAction(actionEvent -> watchListBtnClicked());
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
