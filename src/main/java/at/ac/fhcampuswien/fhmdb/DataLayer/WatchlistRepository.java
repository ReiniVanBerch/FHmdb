package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.List;

@DatabaseTable(tableName = "watchlist")
public class WatchlistRepository {
    private final Dao<WatchlistMovieEntity, Long> dao;

    public WatchlistRepository() throws SQLException {
        this.dao = DaoManager.createDao(DatabaseManager.getConn(), WatchlistMovieEntity.class);
    }

    public List<WatchlistMovieEntity> getWatchlist() throws SQLException {
        return dao.queryForAll();
    }

    public int addToWatchlist(WatchlistMovieEntity movie) throws SQLException {
        List<WatchlistMovieEntity> existing = dao.queryForEq("apiId", movie.getApiId());
        if (existing.isEmpty()) {
            return dao.create(movie);
        }
        return 0;
    }

    public int removeFromWatchlist(String apiId) throws SQLException {
        List<WatchlistMovieEntity> entries = dao.queryForEq("apiId", apiId);
        int deleted = 0;
        for (WatchlistMovieEntity entry : entries) {
            deleted += dao.delete(entry);
        }
        return deleted;
    }
}
