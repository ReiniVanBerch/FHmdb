package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;

public class ControllerBaseHome extends ControllerBase {
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
        //watchListBtn.setOnAction(actionEvent -> watchListBtnClicked());

    }

}