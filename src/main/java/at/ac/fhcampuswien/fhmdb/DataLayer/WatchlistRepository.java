package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.List;


public class WatchlistRepository {
    private final Dao<WatchlistMovieEntity, Long> dao;

    public WatchlistRepository() throws DatabaseException {

        DatabaseManager dm = new DatabaseManager();
        this.dao = dm.getWatchlistDao();

    }

    public List<WatchlistMovieEntity> getWatchlist() throws SQLException {
        return dao.queryForAll();
    }

    public int addToWatchlist(WatchlistMovieEntity movie) throws DatabaseException {
        try {
            List<WatchlistMovieEntity> existing = dao.queryForEq("apiId", movie.getApiId());
            if (existing.isEmpty()) {
                return dao.create(movie);
            }
            return 0;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
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
            throw new DatabaseException(e.getMessage());
        }
    }
}
