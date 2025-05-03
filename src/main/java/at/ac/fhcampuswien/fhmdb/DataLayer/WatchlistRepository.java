package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import java.sql.SQLException;
import java.util.List;


public class WatchlistRepository {
    private final Dao<WatchlistMovieEntity, Long> dao;

    public WatchlistRepository() throws SQLException {
        this.dao = DaoManager.createDao(DatabaseManager.getConn(), WatchlistMovieEntity.class);
    }

    public List<WatchlistMovieEntity> getWatchlist() throws SQLException {
        return dao.queryForAll();
    }

    public void addToWatchlist(WatchlistMovieEntity movie) throws SQLException {
        List<WatchlistMovieEntity> existing = dao.queryForEq("apiId", movie.getApiId());
        if (existing.isEmpty()) {
            dao.create(movie);
        }
    }

    public void removeFromWatchlist(String apiId) throws SQLException {
        List<WatchlistMovieEntity> entries = dao.queryForEq("apiId", apiId);
        for (WatchlistMovieEntity entry : entries) {
            dao.delete(entry);
        }
    }
}
