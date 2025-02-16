package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        movies.add(new Movie("Good Boys","A movie about a group of dogs, trying to be good, so they can get praise",List.of(Genre.ACTION,Genre.ADVENTURE)));
        movies.add(new Movie("Funny Games","Two boys visit a family and try to entertain them, based on a real event",List.of(Genre.BIOGRAPHY,Genre.COMEDY)));
        movies.add(new Movie("Slow and boring","a group of bicyclist are investigated by an undercover cop",List.of(Genre.CRIME,Genre.FAMILY)));
        movies.add(new Movie("Chabin in the forrest","A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting",List.of(Genre.FANTASY,Genre.HORROR,Genre.ROMANCE)));
        movies.add(new Movie("Triathlon - the documentation","One of sports greatest moment as you watch a live recorded triathlon for 7 hours",List.of(Genre.SPORT)));
        movies.add(new Movie("Dont look down", "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY)));
        movies.add(new Movie("Complex Instinct","A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time",List.of(Genre.THRILLER)));
        movies.add(new Movie("The Good, The Bad and the Beautiful","A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often",List.of(Genre.WESTERN)));

        return movies;
    }

    @Override
    public String toString() {

        return "Title: " + this.getTitle() + " Description: " + this.getDescription() + "Genre: " + this.getGenres();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(description, movie.description) && Objects.equals(genres, movie.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, genres);
    }
}
