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



    public Movie(String id, String title, List<Genre> genres, int releaseYear, String description, String imgURL, int lengthInMinutes, double rating) {
        this.id = id;
        this.title = title;
        this.description = description;
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

        movies.add(new Movie("1","Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,3.7 ));
        movies.add(new Movie("2","Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ));
        movies.add(new Movie("3","New Kids Turbo",List.of(Genre.HISTORY),2002,"crazy people from the netherlands decide that their life needs a change","URL3", 133,1.2));
        movies.add(new Movie("4","Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4));
        movies.add(new Movie("5","We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4));
        movies.add(new Movie("6","Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        movies.add(new Movie("7","The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5));
        movies.add(new Movie("8","Good Boys",List.of(Genre.ACTION,Genre.ADVENTURE),2010,"A movie about a group of dogs, trying to be good, so they can get praise","URL7",155,2.2));
        movies.add(new Movie("9","Funny Games",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2024,"Two boys visit a family and try to entertain them, based on a real event","URL8",129,5));
        movies.add(new Movie("10","Slow and boring",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2025,"a group of bicyclist are investigated by an undercover cop","URL9",111,3));
        movies.add(new Movie("11","Chabin in the forrest",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2016,"A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting","URL10",22,3));
        movies.add(new Movie("12","Triathlon - the documentation",List.of(Genre.SPORT),2009,"One of sports greatest moment as you watch a live recorded triathlon for 7 hours","URL11",475,1));
        movies.add(new Movie("13","Dont look down",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY),2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth","URL12",112,2));
        movies.add(new Movie("14","Complex Instinct",List.of(Genre.THRILLER),2004,"A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time","URL13",140,3));
        movies.add(new Movie("15","The Good, The Bad and the Beautiful",List.of(Genre.WESTERN),1975,"A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often","URL14",190,4.5));
        movies.add(new Movie("16","This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ));
        movies.add(new Movie("17","All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 ));

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
