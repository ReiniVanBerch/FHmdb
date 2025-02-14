package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres;
    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres =genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres(){ return genres; }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        movies.add(new Movie("Der Soldat Jamey Ryan", "Eine Gruppe an Soldaten rettet einen einzelnen Soldaten", List.of(Genre.WAR)));
        movies.add(new Movie("Schneewittchen","Sieben einsame kleinwüchsige Menschen finden ein Waisenkind", List.of(Genre.DOCUMENTARY)));
        movies.add(new Movie("New Kids Turbo","verrückter Mongojunge, Busfahrer",List.of(Genre.HISTORY)));
        return movies;
    }
}
