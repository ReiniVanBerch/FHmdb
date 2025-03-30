package at.ac.fhcampuswien.fhmdb;

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
import javafx.scene.control.TextField;

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
    public JFXComboBox releaseyearComboBox;

    @FXML
    public JFXComboBox ratingComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

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
        releaseyearComboBox.getItems().add("all release years");
       // releaseyearComboBox.getItems().addAll(allMovies.sort(Comparator.comparing(Movie::getReleaseYear)).release
         //       );
        releaseyearComboBox.setPromptText("Filter by release year");
        //ratings button
        ratingComboBox.getItems().add("all ratings");
        ratingComboBox.setPromptText("Filter by ratings");
        //set initial sort button text
        sortBtn.setText("Sort (desc)");

        sortBtn.setOnAction(actionEvent -> sort());
        searchBtn.setOnAction(actionEvent -> searchBtnClicked());

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

        return 2;
    }
    //gibt die Anzahl der Filme eines bestimmten Regisseurs zurück.
    public long countMoviesFrom(List<Movie> movies, String director){

        return 4;
    }

    //gibt jene Filme zurück, die zwischen zwei gegebenen Jahren veröffentlicht wurden.
    public List<Movie> getMoviesBetweenYears(List<Movie> movies, int startYear, int endYear){
        List<Movie> result = new ArrayList<>();
        //these 2 are just temporary, remove after adding the function
        movies.add(new Movie("1","Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,List.of("Tom Hanks","Steven Spielberg"),List.of("Tom Hanks","Vin Diesel"),List.of("Tom Hanks"),3.7 ));
        movies.add(new Movie("2","Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));

        return result;
    }

}