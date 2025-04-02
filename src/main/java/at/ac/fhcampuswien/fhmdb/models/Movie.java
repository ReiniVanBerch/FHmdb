package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.API.MovieAPI;
import com.google.gson.annotations.SerializedName;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.*;

public class Movie {
    @SerializedName("id") private UUID id;
    @SerializedName("title") private String title;
    @SerializedName("genres") private List<Genre> genres;
    @SerializedName("releaseYear") private int releaseYear;
    @SerializedName("description") private String description;
    @SerializedName("imgUrl") private String imgURL;
    @SerializedName("lengthInMinutes") private int lengthInMinutes;
    @SerializedName("directors") private List<String> directors;
    @SerializedName("writers") private List<String> writers;
    @SerializedName("mainCast") private List<String> mainCast;
    @SerializedName("rating") private double rating;



    public Movie(UUID id,
                 String title,
                 List<Genre> genres,
                 int releaseYear,
                 String description,
                 String imgURL,
                 int lengthInMinutes,
                 double rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgURL = imgURL;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

    public Movie( String title,
                 List<Genre> genres,
                 int releaseYear,
                 String description,
                 String imgURL,
                 int lengthInMinutes,
                 double rating) {
        this(UUID.randomUUID(), title, genres, releaseYear, description, imgURL, lengthInMinutes, rating);
    }

    //Konstruktor für Movie mit director, writer und main cast
    public Movie(UUID id, String title, List<Genre> genres, int releaseYear, String description, String imgURL, int lengthInMinutes,List<String> directors, List<String> writers, List<String> maincast, double rating) {
        this(id, title, genres, releaseYear, description, imgURL, lengthInMinutes, rating);

        this.directors = directors;
        this.writers = writers;
        this.mainCast = maincast;

    }

    //Konstruktor für Movie mit director, writer und main cast
    public Movie(String title, List<Genre> genres, int releaseYear, String description, String imgURL, int lengthInMinutes,List<String> directors, List<String> writers, List<String> maincast, double rating) {
        this(UUID.randomUUID(), title, genres, releaseYear, description, imgURL, lengthInMinutes, directors, writers, maincast, rating);
    }


    public UUID getId() {
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
        MovieAPI api = new MovieAPI();

        //UUID uuid = UUID.fromString("81d317b0-29e5-4846-97a6-43c07f3edf4a");
        //String response = example.getMovie(uuid);
        //String response = example.getMovies().get(0).toString();
        try{
            return api.getMovies();
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
            return null;
        }

    }

    public static List<Movie> initializeMoviesLocal(){
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,List.of("Tom Hanks","Steven Spielberg"),List.of("Tom Hanks","Vin Diesel"),List.of("Tom Hanks"),3.7 ));
        movies.add(new Movie("Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        movies.add(new Movie("New Kids Turbo",List.of(Genre.HISTORY),2002,"crazy people from the netherlands decide that their life needs a change","URL3", 133,1.2));
        movies.add(new Movie("Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,List.of("Steve Rogers","James May"),List.of("Tom Cruise","Celine Dion"),List.of("Ozzy Osbourne"),2.4));
        movies.add(new Movie("We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        movies.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        movies.add(new Movie("The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5));
        movies.add(new Movie("Good Boys",List.of(Genre.ACTION,Genre.ADVENTURE),2010,"A movie about a group of dogs, trying to be good, so they can get praise","URL7",155,2.2));
        movies.add(new Movie("Funny Games",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2024,"Two boys visit a family and try to entertain them, based on a real event","URL8",129,5));
        movies.add(new Movie("Slow and boring",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2025,"a group of bicyclist are investigated by an undercover cop","URL9",111,3));
        movies.add(new Movie("Chabin in the forrest",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2016,"A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting","URL10",22,3));
        movies.add(new Movie("Triathlon - the documentation",List.of(Genre.SPORT),2009,"One of sports greatest moment as you watch a live recorded triathlon for 7 hours","URL11",475,1));
        movies.add(new Movie("Dont look down",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY),2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth","URL12",112,2));
        movies.add(new Movie("Complex Instinct",List.of(Genre.THRILLER),2004,"A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time","URL13",140,3));
        movies.add(new Movie("The Good, The Bad and the Beautiful",List.of(Genre.WESTERN),1975,"A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often","URL14",190,4.5));
        movies.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        movies.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

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
