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
        movies.add(new Movie("Saving Private Jamey Ryan", "a captain is on the search for the last surviving son of a family", List.of(Genre.WAR)));
        movies.add(new Movie("Snow White","seven dwarf rise a orphan child that they found in the woods", List.of(Genre.DOCUMENTARY)));
        movies.add(new Movie("New Kids Turbo","crazy people from the netherlands decide that their life needs a change",List.of(Genre.HISTORY)));
        movies.add(new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA)));
        movies.add(new Movie("We will never be royals", "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood",List.of(Genre.DOCUMENTARY,Genre.MUSICAL)));
        movies.add(new Movie("Wrong Direction", "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran",List.of(Genre.DRAMA,Genre.MYSTERY)));
        movies.add(new Movie("The greatest Snowman","a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL)));

        return movies;
    }
}
