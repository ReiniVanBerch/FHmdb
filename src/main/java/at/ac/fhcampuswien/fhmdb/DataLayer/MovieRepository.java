package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.Exception.DatabaseException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.List;


@DatabaseTable(tableName = "movies")
public class MovieRepository {
    private final Dao<MovieEntity, Long> dao;

    public MovieRepository() throws DatabaseException {
        DatabaseManager dm = new DatabaseManager();
        this.dao = dm.getMovieDao();
    }

    public List<MovieEntity> getAllMovies() throws DatabaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

    }

    public int removeAll() throws SQLException {
        return dao.deleteBuilder().delete();
    }

    public MovieEntity getMovie() throws DatabaseException {
         // Liste leer --> null , sonnst den ersten Film
        try {
            List<MovieEntity> all = dao.queryForAll();
            return all.isEmpty() ? null : all.get(0);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

    }

    public MovieEntity getMovie(String apiId) throws DatabaseException {
        try{

            return dao.queryBuilder().where().eq("apiId", apiId).queryForFirst();
        } catch (SQLException e) {
            throw new DatabaseException(e);
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
            throw new DatabaseException(e);
        }


    }
}