package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Movie {
    private String id;
    private String title;
    private List<Genre> genres;
    private int releaseYear;
    private String description;
    private String imgURL;
    private int lengthInMinutes;
    private List<String> directors;
    private List<String> writers;
    private List<String> mainCast;
    private double rating;

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres =genres;
    }

    public Movie(String id, String title, List<Genre> genres, int releaseYear, String description, String imgURL, int lengthInMinutes, double rating) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgURL = imgURL;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<String> getMainCast() {
        return mainCast;
    }

    public double getRating() {
        return rating;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

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
        movies.add(new Movie("This is us", "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", List.of(Genre.DOCUMENTARY)));
        movies.add(new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY)));

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
