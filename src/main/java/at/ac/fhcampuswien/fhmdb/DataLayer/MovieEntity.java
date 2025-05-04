package at.ac.fhcampuswien.fhmdb.DataLayer;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.*;

@DatabaseTable(tableName = "movies")
public class MovieEntity {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String apiId;

    @DatabaseField(canBeNull = false)
    private String title;

    @DatabaseField()
    private String description;

    @DatabaseField()
    private String genres;

    @DatabaseField()
    private int releaseYear;

    @DatabaseField()
    private String imgUrl;

    @DatabaseField()
    private int lengthInMinutes;

    @DatabaseField()
    private double rating;

    public MovieEntity()
    {

    }

    public MovieEntity(String apiId, String title, String description, String genres, int releaseYear,
                       String imgUrl, int lengthInMinutes, double rating) {
        this.apiId = apiId;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;

    }

    public long getId() {
        return id;
    }

    public String getApiId() {
        return apiId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        return genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public double getRating() {
        return rating;
    }



    public List<Genre> getGenresAsList() {
        return Arrays.stream(genres.split(",")).map(Genre::valueOf).toList();
    }

    public String genresToString(List<Genre> genres) {
        StringBuilder genreList = new StringBuilder();
        for (Genre g : genres) {
            genreList.append(g.name()).append(",");

        }
        genreList.setLength(genreList.length() - 1);
        return genreList.toString();
    }

    public List<MovieEntity> fromMovies (List<Movie> movies) {
        List<MovieEntity> movieEntities = new ArrayList<>();

        for (Movie m : movies) {
            movieEntities.add(new MovieEntity(m.getId().toString(), m.getTitle(), m.getDescription(),
                    m.getGenres().toString(), m.getReleaseYear(), m.getImgURL(), m.getLengthInMinutes(), m.getRating()));
        }

        return movieEntities;
    }

    public List<Movie> toMovies (List<MovieEntity> movieEntities) {

        List<Movie> movies = new ArrayList<>();
        for (MovieEntity me : movieEntities) {
            movies.add(new Movie(UUID.fromString(me.getApiId()), me.getTitle(),  me.getGenresAsList(), me.getReleaseYear(),
                    me.getDescription(), me.getImgUrl(), me.getLengthInMinutes(), me.getRating()));
        }
        return movies;
    }


}
