package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
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

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXComboBox releaseYearComboBox;

    @FXML
    public JFXComboBox ratingComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();
    public List<Movie> watchlistMovies;

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes
    @FXML
    public JFXButton watchListBtn;

    public boolean watchlist =false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeLogic();
        initializeUI();
    }

    public void initializeLogic() {
        observableMovies.clear();
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        //initial sort state
        sortAscending(observableMovies);


        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:

    }

    public void initializeUI() {
        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // add Genres to selection (and option to not filter)
        Genre[] genres = Genre.values();
        genreComboBox.getItems().add("all genres");
        genreComboBox.getItems().addAll(genres);
        genreComboBox.setPromptText("Filter by Genre");

        //add releaseyears
        releaseYearComboBox.getItems().add("all release years");
       // releaseyearComboBox.getItems().addAll(allMovies.sort(Comparator.comparing(Movie::getReleaseYear)).release
         //       );
        Integer[] years = new Integer[125];
        for (int i = 0; i < years.length; i++) {
            years[i] = 1900 + i;
        }
        releaseYearComboBox.getItems().addAll(years);
        releaseYearComboBox.setPromptText("Filter by release year");
        //ratings button
        ratingComboBox.getItems().add("all ratings");
        Integer[] ratings = new Integer[11];
        for (int i = 0; i < ratings.length; i++) {
            ratings[i] = i;
        }
        ratingComboBox.getItems().addAll(ratings);

        ratingComboBox.setPromptText("Filter by ratings");
        //set initial sort button text
        sortBtn.setText("Sort (desc)");

        sortBtn.setOnAction(actionEvent -> sort());
        searchBtn.setOnAction(actionEvent -> searchBtnClicked());
        watchListBtn.setOnAction(actionEvent -> watchListBtnClicked());

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

            try{int ratingInt = ((int) ratingComboBox.getSelectionModel().getSelectedItem());
            rating = ratingInt;}
            catch (Exception e) {
                System.out.println(e);
                rating = 0;}

            observableMovies.clear();
            observableMovies.addAll(api.getMovies(title, genre, releaseYear, rating));
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

    public void sortAscending(ObservableList<Movie> list) {
        list.sort(Comparator.comparing(Movie::getTitle));
    }

    public void sortDescending(ObservableList<Movie> list) {
        list.sort(Comparator.comparing(Movie::getTitle).reversed());
    }

    //still to do return most popular actor of sent movie
    public String getMostPopularActor(List<Movie> movies){
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
    public int getLongestMovieTitle(List<Movie> movies){
        return movies.stream()
                .mapToInt(movie -> movie.getTitle().length())
                .max()
                .orElse(0);
    }

    //gibt die Anzahl der Filme eines bestimmten Regisseurs zurück.
    public long countMoviesFrom(List<Movie> movies, String director){
        return movies.stream()
                .filter(movie -> movie.getDirectors() != null)
                .filter(movie -> movie.getDirectors().contains(director))
                .count();

    }

    //gibt jene Filme zurück, die zwischen zwei gegebenen Jahren veröffentlicht wurden.
    public List<Movie> getMoviesBetweenYears(List<Movie> movies, int startYear, int endYear){

        return movies.stream()
                .filter(movie -> movie.getReleaseYear() >= startYear && movie.getReleaseYear() <= endYear)
                .collect(Collectors.toList());
    }

    public void watchListBtnClicked(){

        if (!watchlist) {
            observableMovies.clear();
            MovieAPI api = new MovieAPI();
            try {
                observableMovies.addAll(api.getMovies("Dark Knight", "ACTION", 2008, 0));
                watchlist = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            watchlist = false;
            searchBtnClicked();
        }





    }


    /*
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