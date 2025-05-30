package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import at.ac.fhcampuswien.fhmdb.AlertHelper;
import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseManager {

    private static String DB_URL = "jdbc:h2:./Data/moviedb";
    private static String username = "admin";
    private static String password = "";
    private ConnectionSource conn;
    private Dao<MovieEntity, Long> movieDao;
    private Dao<WatchlistMovieEntity, Long> watchlistDao;

    private static DatabaseManager instance = new DatabaseManager();



    private DatabaseManager()  {
        try{
            try {
                init();
            } catch (DatabaseException | MovieApiException e) {
                throw new DatabaseException("INIT in DatabaseManager failed: " + e.getMessage());
            }
        } catch (DatabaseException e) {
            AlertHelper.buildAlert("Database error", e.getMessage());
        }
    }

    public static DatabaseManager getInstance() {
        return instance;
    }


    public void init() throws DatabaseException, MovieApiException {
        createConnectionSource();
        createTables();
    }

    public void createConnectionSource() throws DatabaseException {
        try {
            this.conn = new JdbcConnectionSource(DB_URL, username, password);
            this.movieDao = DaoManager.createDao(this.conn, MovieEntity.class);
            this.watchlistDao = DaoManager.createDao(this.conn, WatchlistMovieEntity.class);
        } catch (SQLException e) {
            throw new DatabaseException("create Connection in DatabaseManager failed: " + e.getMessage());
        }
;
    }

    public ConnectionSource getConn() {
        return conn;
    }


    public void createTables() throws DatabaseException, MovieApiException {
        try{

            TableUtils.createTableIfNotExists(conn, MovieEntity.class);
            TableUtils.createTableIfNotExists(conn, WatchlistMovieEntity.class);
            if(movieDao.queryForAll().isEmpty()){
                try {
                    MovieAPI api = new MovieAPI();
                    this.getMovieDao().create(api.getMovies("", "", 0, 0));
                } catch (MovieApiException e) {
                    throw new MovieApiException("fetching initial movies failed in create tables in DatabaseManager " + e.getMessage());
                } catch (SQLException e) {
                    throw new DatabaseException("insert initial movies failed in create tables in DatabaseManager" + e.getMessage());
                }

            }

        } catch (SQLException e) {
            throw new DatabaseException("create tables failed in DatabaseManager" + e.getMessage());
        }
    }

    public Dao<WatchlistMovieEntity, Long> getWatchlistDao() {

        return watchlistDao;
    }

    public Dao<MovieEntity, Long> getMovieDao() {

        return movieDao;
    }
}
