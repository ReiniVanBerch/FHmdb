package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseManager {

    private static String DB_URL = "jdbc:h2:./DataLayer/moviedb";
    private static String username = "admin";
    private static String password = "";
    private static ConnectionSource conn;
    private static Dao<MovieEntity, Long> movieDao;
    private static Dao<WatchlistMovieEntity, Long> watchlistDao;

    public DatabaseManager() throws SQLException {
        init();
    }

    public static void init() throws SQLException {
        createConnectionSource();
        createTables();
    }

    public static void createConnectionSource() throws SQLException {
        conn = new JdbcConnectionSource(DB_URL, username, password);
        movieDao = DaoManager.createDao(conn, MovieEntity.class);
        watchlistDao = DaoManager.createDao(conn, WatchlistMovieEntity.class);
    }

    public static ConnectionSource getConn() {
        return conn;
    }


    public static void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(conn, MovieEntity.class);
        TableUtils.createTableIfNotExists(conn, WatchlistMovieEntity.class);
    }

    public static Dao<WatchlistMovieEntity, Long> getWatchlistDao() {

        return watchlistDao;
    }

    public static Dao<MovieEntity, Long> getMovieDao() {

        return movieDao;
    }
}
