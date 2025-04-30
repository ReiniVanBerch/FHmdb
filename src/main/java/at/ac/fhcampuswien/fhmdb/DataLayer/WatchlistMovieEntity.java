package at.ac.fhcampuswien.fhmdb.DataLayer;

import com.j256.ormlite.field.DatabaseField;

public class WatchlistMovieEntity {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String apiId;

    public WatchlistMovieEntity() {

    }

    public WatchlistMovieEntity(String apiId) {
        this.apiId = apiId;
    }

    public long getId() {
        return id;
    }

    public String getApiId() {
        return apiId;
    }
}
