package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import java.sql.SQLException;
import java.util.List;


public class MovieRepository {
    private final Dao<MovieEntity, Long> dao;

    public MovieRepository() throws SQLException {
        this.dao = DaoManager.createDao(DatabaseManager.getConn(), MovieEntity.class);
    }

    public List<MovieEntity> getAllMovies() throws SQLException {
        return dao.queryForAll();
    }

    public int removeAll() throws SQLException {
        return dao.deleteBuilder().delete();
    }

    public MovieEntity getMovie() throws SQLException {
        List<MovieEntity> all = dao.queryForAll();
        return all.isEmpty() ? null : all.get(0);      // Liste leer --> null , sonnst den ersten Film
    }

    public void addAllMovies(List<MovieEntity> movies) throws SQLException {
        for (MovieEntity movie : movies) {
            dao.createOrUpdate(movie);
        }
    }
}