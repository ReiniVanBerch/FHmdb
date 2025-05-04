package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "watchlist")
public class WatchlistMovieEntity {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String apiId;

    public WatchlistMovieEntity(String apiId) {
        this.apiId = apiId;
    }

    public String getApiId() {
        return apiId;
    }
}
