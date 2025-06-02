package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
import at.ac.fhcampuswien.fhmdb.Observable;
import at.ac.fhcampuswien.fhmdb.Observer;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WatchlistRepository implements Observable {
    private static WatchlistRepository instance = new WatchlistRepository();

    private final Dao<WatchlistMovieEntity, Long> dao;



    private WatchlistRepository() {

        DatabaseManager dm = DatabaseManager.getInstance();
        this.dao = dm.getWatchlistDao();
    }

    public static WatchlistRepository getInstance() {
        return instance;
    }

    public List<WatchlistMovieEntity> getWatchlist() throws DatabaseException {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new DatabaseException("Fehler beim laden deiner Watchlist. " + e.getMessage());
        }
    }

    public int addToWatchlist(WatchlistMovieEntity movie) throws DatabaseException {
        try {
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                int result = dao.create(movie);
                notifyObservers("Movie successfully added to watchlist!");
                return result;
            } else {
                notifyObservers("Movie already on watchlist!");
                return 0;
            }
        } catch (SQLException e) {
            notifyObservers("Fehler beim Hinzufügen des Films zur Watchlist: " + e.getMessage());
            throw new DatabaseException("Fehler beim Hinzufügen des Films zur Watchlist. " + e.getMessage());
        }
    }

    public int removeFromWatchlist(String apiId) throws DatabaseException {
        try {
            List<WatchlistMovieEntity> entries = dao.queryForEq("apiId", apiId);
            int deleted = 0;
            for (WatchlistMovieEntity entry : entries) {
                deleted += dao.delete(entry);
            }
            if (deleted > 0) {
                notifyObservers("Movie successfully removed from watchlist!");
            } else {
                notifyObservers("Movie was not on watchlist!");
            }
            return deleted;
        } catch (SQLException e) {
            notifyObservers("Fehler beim Entfernen des Films aus der Watchlist: " + e.getMessage());
            throw new DatabaseException("Fehler beim Entfernen des Films aus der Watchlist. " + e.getMessage());
        }
    }


    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
