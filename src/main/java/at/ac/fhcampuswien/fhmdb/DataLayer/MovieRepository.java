package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.Exception.MovieApiException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.List;


@DatabaseTable(tableName = "movies")
public class MovieRepository {
    private final Dao<MovieEntity, Long> dao;
    private static final MovieRepository instance = new MovieRepository();

    public static MovieRepository getInstance() {
        return instance;
    }

    private MovieRepository() {
        DatabaseManager dm = DatabaseManager.getInstance();
        this.dao = dm.getMovieDao();
    }

    public List<MovieEntity> getAllMovies() throws DatabaseException {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new DatabaseException("Fehler beim Laden der Filme. " + e);
        }

    }

    public int removeAll() throws DatabaseException {
        try {
            return dao.deleteBuilder().delete();
        } catch (SQLException e) {
            throw new DatabaseException("Fehler beim Entfernen der Filme. " + e);
        }
    }

    public MovieEntity getMovie() throws DatabaseException {
         // Liste leer --> null , sonnst den ersten Film
        try {
            List<MovieEntity> all = dao.queryForAll();
            return all.isEmpty() ? null : all.get(0);
        } catch (Exception e) {
            throw new DatabaseException("Fehler beim Abrufen eines Films aus der Datenbank. " + e);
        }

    }

    public MovieEntity getMovie(String apiId) throws DatabaseException {

        try{
            return dao.queryBuilder().where().eq("apiId", apiId).queryForFirst();
        } catch (SQLException e) {
            throw new DatabaseException("Fehler beim Laden des Films mit der angegebenen ID. " + e);
        }
    }

    public int addAllMovies(List<MovieEntity> movies) throws DatabaseException {

        try {
            int count = 0;
            for (MovieEntity movie : movies) {
                dao.createOrUpdate(movie);
                count++;
            }
            return count;
        } catch (Exception e) {
            throw new DatabaseException("Fehler beim Speichern der Filme in der DAtenbank. " + e);
        }

    }
}