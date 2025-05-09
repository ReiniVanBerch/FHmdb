package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class WatchlistRepository {
    private final Dao<WatchlistMovieEntity, Long> dao;

    public WatchlistRepository() throws DatabaseException, MovieApiException {

        DatabaseManager dm = new DatabaseManager();
        this.dao = dm.getWatchlistDao();

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
                return dao.create(movie);
            } else{
                return 0;
            }

        } catch (SQLException e) {
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
            return deleted;
        } catch (SQLException e) {
            throw new DatabaseException("Fehler beim Entfernen des Films aus der Watchlist. " + e.getMessage());
        }
    }
}
