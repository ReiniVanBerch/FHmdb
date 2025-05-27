package at.ac.fhcampuswien.fhmdb.Controller;

import at.ac.fhcampuswien.fhmdb.AlertHelper;
import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.MovieRepository;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.DataLayer.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import at.ac.fhcampuswien.fhmdb.ui.MovieCellWatchlist;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;



public class ControllerBaseWatchlist extends ControllerBase{

    @FXML
    public JFXListView movieWatchlistListView;

    private WatchlistRepository watchlistRepository;
    private List<MovieEntity> watchlistMovies = new ArrayList<>();
    private ObservableList<MovieEntity> observableMovies = FXCollections.observableArrayList();

    private final ClickEventHandler onRemoveFromWatchlistClicked = (clickedItem) -> {
        try{
            if(clickedItem instanceof MovieEntity movie){

                watchlistRepository.removeFromWatchlist(movie.getApiId());

                watchlistMovies.remove(movie.getApiId());

                update();
            }
        }
        catch (DatabaseException e) {
            AlertHelper.buildAlert("Database Error", e.getMessage());
        }
    };

    public ControllerBaseWatchlist() throws MovieApiException, DatabaseException {
        super();
        watchlistRepository = WatchlistRepository.getInstance();
        update();

    }

    public void update(){

        List<WatchlistMovieEntity> watchlistMoviesAsList;
        try {

            try {


                watchlistMoviesAsList = watchlistRepository.getWatchlist();


                List<String> apiIds = watchlistMoviesAsList.stream()
                        .map(WatchlistMovieEntity::getApiId)
                        .collect(Collectors.toList());

                watchlistMovies.clear();
                watchlistMovies = dbm.getMovieDao().queryBuilder()
                        .where()
                        .in("apiId", apiIds)
                        .query();

                observableMovies.clear();
                observableMovies.setAll(watchlistMovies);

            } catch (SQLException e) {
                throw new DatabaseException(e);
            }




        } catch (DatabaseException e) {
            AlertHelper.buildAlert("DataBaseError", e.getMessage());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        sortAscending(observableMovies);

        initializeUI(onRemoveFromWatchlistClicked);


    }


    public void initializeUI(ClickEventHandler clickEventHandler){
        super.initializeUI(clickEventHandler);

        movieWatchlistListView.setItems(observableMovies);   // set data of observable list to list view

        movieWatchlistListView.setCellFactory(movieListView -> new MovieCellWatchlist(clickEventHandler)); // use custom cell factory to display data
    }

}
