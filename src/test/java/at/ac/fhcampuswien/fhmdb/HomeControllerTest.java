package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HomeControllerTest {

    static HomeController homeController;
    static ArrayList<Movie> testMovies;

    @BeforeAll
    static void init(){
        homeController = new HomeController();

        testMovies = new ArrayList<>();
        testMovies.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testMovies.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        homeController.allMovies = testMovies;
    }

    @Test
    @DisplayName("Movie: Testet den Initializier")
    public void movie_test_the_initializer(){
        List<Movie> test =   Movie.initializeMovies();
        assertNotNull(test);
    }

    @Test
    @DisplayName("Testing the MostPopularActor")
    public void check_getMostPopularActorTest(){
        String expected = "Louis Tomlinson";
        String actual = homeController.getMostPopularActor(testMovies);

        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Checks if the Actor playing in the most movies gets returned")
    public void check_actor_with_most_movies(){
        HomeController test = new HomeController();
        List<Movie> testList = new ArrayList<>();
        testList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        testList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        String actual = test.getMostPopularActor(testList);
        String expected = "Louis Tomlinson";

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Testing the LongestMovieTitle")
    public void check_getLongestMovieTitle(){
        int expected = 19;
        int actual = homeController.getLongestMovieTitle(testMovies);

        assertEquals(expected, actual);
    }





    @Test
    @DisplayName("Check for the longest movie title")
    public void check_movie_length(){
        HomeController test = new HomeController();
        List<Movie> testList = new ArrayList<>();
        testList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        testList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        int actual = test.getLongestMovieTitle(testList);
        int expected = 19;
        assertEquals(expected, actual);


    }


    @Test
    @DisplayName("Check for the most movies from one director")
    public void check_movies_director_zero(){
        HomeController test = new HomeController();
        List<Movie> testList = new ArrayList<>();
        testList.add(new Movie("Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5));
        testList.add(new Movie("This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,List.of("Morgan Spurlock", "Charlie Lightning"),List.of("Morgan Spurlock","Adam Milano","Ben Winston","Simon Cowell"),List.of("Niall Horan","Zayn Malik","Liam Payne","Harry Styles","Louis Tomlinson"),4.7 ));
        testList.add(new Movie("All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,List.of("Charlie Lightning"),List.of("Stefan Demetriou"),List.of("Louis Tomlinson"),4.3 ));

        long actual = test.countMoviesFrom(testList,"Lewis Hamilton");
        long expected = 0;
        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Testing the countMoviesFrom")
    public void check_countMoviesFromTest(){
        long expected = 1;
        long actual = homeController.countMoviesFrom(testMovies, "Charlie Lightning");

        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Check Movie between years: both")
    public void check_getMovieBetweenYears(){
        List<Movie> expected = testMovies;
        List<Movie> actual = homeController.getMoviesBetweenYears(testMovies, 2012, 2025);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Check Movie between years: single")
    public void check_getMovieBetweenYears_1(){
        List<Movie> expected = new ArrayList<>(Arrays.asList(testMovies.get(0)));
        List<Movie> actual = homeController.getMoviesBetweenYears(testMovies, 2012, 2017);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Check Movie between years: single later")
    public void check_getMovieBetweenYears_2(){
        List<Movie> expected = new ArrayList<>(Arrays.asList(testMovies.get(1)));
        List<Movie> actual = homeController.getMoviesBetweenYears(testMovies, 2017, 2025);
        assertEquals(expected, actual);

    }

}
