package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "watchlist")
public class WatchlistMovieEntity extends MovieEntity {

    public WatchlistMovieEntity() {}
    public WatchlistMovieEntity(String apiId) {
        this.apiId = apiId;
    }

    public String getApiId() {
        return apiId;
    }
}
