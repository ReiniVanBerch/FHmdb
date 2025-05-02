package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import at.ac.fhcampuswien.fhmdb.ui.MovieCellWatchlist;

import java.io.IOException;

public class ControllerBaseWatchlist extends ControllerBase{
    public void initializeUI(){
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCellWatchlist()); // use custom cell factory to display data
        observableMovies.clear();
        MovieAPI api = new MovieAPI();
        try {
            observableMovies.addAll(api.getMovies("Dark Knight", "ACTION", 2008, 0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
