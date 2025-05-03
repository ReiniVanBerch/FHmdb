package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseManager {

    private String DB_URL;
    private String username;
    private String password;
    private static ConnectionSource conn;
    private Dao<MovieEntity, Long> movieDao;
    private Dao<WatchlistMovieEntity, Long> watchlistDao;

    public DatabaseManager(String DB_URL, String username, String password) {
        this.DB_URL = DB_URL;
        this.username = username;
        this.password = password;
    }

    public void createConnectionSource() throws SQLException {
        conn = new JdbcConnectionSource(DB_URL, username, password);
        movieDao = DaoManager.createDao(conn, MovieEntity.class);
        watchlistDao = DaoManager.createDao(conn, WatchlistMovieEntity.class);
    }

    public static ConnectionSource getConn() {
        return conn;
    }


    public void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(conn, MovieEntity.class);
        TableUtils.createTableIfNotExists(conn, WatchlistMovieEntity.class);
    }

    public Dao<WatchlistMovieEntity, Long> getWatchlistDao() {

        return watchlistDao;
    }

    public Dao<MovieEntity, Long> getMovieDao() {

        return movieDao;
    }
}
