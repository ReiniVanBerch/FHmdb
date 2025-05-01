package at.ac.fhcampuswien.fhmdb.API;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MovieAPITest {

    static ArrayList<Movie> testMovies;

    @BeforeAll
    static void init(){
        testMovies = new ArrayList<>();
        testMovies.add(new Movie(UUID.fromString("81d317b0-29e5-4846-97a6-43c07f3edf4a"), "This is us", List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testMovies.add(new Movie(UUID.fromString("81d317b0-29e5-4846-97a6-43c07f3edf4b"), "All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

    }

    @Test
    @DisplayName("Getting all the movies.")
    void check_getMovies(){
        MovieAPI movieAPI = new MovieAPI();
        try {
            ArrayList<Movie> movies = movieAPI.getMovies();
             assertNotNull(movies);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }

    @Test
    @DisplayName("Getting all the movies with D.")
    void check_getMovies_withD(){
        MovieAPI movieAPI = new MovieAPI();
        try {
            ArrayList<Movie> movies = movieAPI.getMovies("D","",0,0.0);
            assertNotEquals(movies, new ArrayList<Movie>());
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }

    @Test
    @DisplayName("Getting all the movies with Action.")
    void check_getMovies_ACTION(){
        MovieAPI movieAPI = new MovieAPI();
        try {
            ArrayList<Movie> movies = movieAPI.getMovies("","ACTION",0,0.0);
            assertNotEquals(movies, new ArrayList<Movie>());
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }
}
