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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

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
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)

        // add Genres to selection (and option to not filter)
        Genre[] genres = Genre.values();
        genreComboBox.getItems().add("all genres");
        genreComboBox.getItems().addAll(genres);
        genreComboBox.setPromptText("Filter by Genre");

        //initial sort state
        sortAscending(observableMovies);
        sortBtn.setText("Sort (desc)");

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here


        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                sortAscending(observableMovies);
                sortBtn.setText("Sort (desc)");

            } else {
                // TODO sort observableMovies descending
                sortDescending(observableMovies);
                sortBtn.setText("Sort (asc)");
            }
        });

        searchBtn.setOnAction(actionEvent -> searchBtnClicked());


    }

    public void sortAscending(ObservableList<Movie> list) {
        list.sort(Comparator.comparing(Movie::getTitle));
    }

    public void sortDescending(ObservableList<Movie> list) {
        list.sort(Comparator.comparing(Movie::getTitle).reversed());
    }

    public List<Movie> filterGenre(List<Movie> moviesList) {
      Object genre = genreComboBox.getSelectionModel().getSelectedItem();
        System.out.println(genre);

      if (genre == null || genre.toString().equals("all genres")) {
          return moviesList;
      } else {
            return moviesList.stream().filter(movie -> movie.getGenres().contains(genre)).toList();
      }
    }

    public List<Movie> filterSearchField(String searchQuery, List<Movie> moviesList) {
        if (searchQuery == null || searchQuery.isEmpty()) {
            return moviesList;
        } else {
            return moviesList.stream().filter(movie ->
                    movie.getTitle().toLowerCase().contains(searchQuery) ||
                    movie.getDescription().toLowerCase().contains(searchQuery)).toList();
        }
    }

    public void searchBtnClicked() {
        String searchQuery = searchField.getText().toLowerCase();
        System.out.println("before trimming: " + searchQuery);
        searchQuery = searchQuery.trim();
        System.out.println("after trimming: " + searchQuery);
        List<Movie> filteredList = new ArrayList<>(allMovies);
        System.out.println("list size all movies: " + filteredList.size());
        filteredList = filterGenre(filteredList);
        System.out.println("list size after genre filter: " + filteredList.size());
        filteredList = filterSearchField(searchQuery, filteredList);
        System.out.println("list size after both filters: " + filteredList.size());
        System.out.println("observable sizeat first: " + observableMovies.size());
        observableMovies.clear();
        System.out.println("observable size after clear: " + observableMovies.size());
        observableMovies.addAll(filteredList);
        System.out.println("observable size after adding: " + observableMovies.size());
        sortAscending(observableMovies);
        System.out.println("observable size after sorting: " + observableMovies.size());
        movieListView.setItems(observableMovies);
        movieListView.refresh();
    }
}