package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import at.ac.fhcampuswien.fhmdb.ui.MovieCellWatchlist;

import java.io.IOException;
import java.util.UUID;

public class ControllerBaseWatchlist extends ControllerBase{
    private final ClickEventHandler onRemoveFromWatchlistClicked = (clickedItem) -> {
        // add code to remove movie from watchlist here

        Movie movie = (Movie) clickedItem;
        UUID uuid = movie.getId();
        String apiId = uuid.toString();

        WatchlistMovieEntity movieEntity = new WatchlistMovieEntity(apiId);







    };

    private void addToWatchlist(WatchlistMovieEntity movie) {
    }

    public void initializeUI(){
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCellWatchlist(onRemoveFromWatchlistClicked)); // use custom cell factory to display data
        observableMovies.clear();
        MovieAPI api = new MovieAPI();
        try {
            observableMovies.addAll(api.getMovies("Dark Knight", "ACTION", 2008, 0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
