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
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import at.ac.fhcampuswien.fhmdb.ui.MovieCellWatchlist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

public class ControllerBaseWatchlist extends ControllerBase{
    private final ClickEventHandler onRemoveFromWatchlistClicked = (clickedItem) -> {
        try{
            if(clickedItem instanceof MovieEntity movie){

                WatchlistRepository watchlistRepository = new WatchlistRepository();
                watchlistRepository.removeFromWatchlist(movie.getApiId());
                observableMovies.remove(movie.getApiId());

            }
        }
        catch (DatabaseException e) {
            AlertHelper.buildAlert("Database Error", e.getMessage());
        }
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
