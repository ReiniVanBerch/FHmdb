package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.AlertHelper;
import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.DataLayer.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;

import java.sql.SQLException;

public class ControllerBaseHome extends ControllerBase {

    private final ClickEventHandler clickEventHandler = (clickedItem) ->
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