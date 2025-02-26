package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovieTest {

    static List<Movie> moviesForTestingLatterBits;
    static Movie movieTest;
    static Movie movieTest2;

    @BeforeAll
    static void init(){
        moviesForTestingLatterBits = Movie.initializeMovies();
        movieTest = moviesForTestingLatterBits.get(0);
        movieTest2 = moviesForTestingLatterBits.get(1);
    }


    @Test
    @DisplayName("Checking the initilizer")
    public void movie_check_initializeMovies_same(){
        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("Saving Private Jamey Ryan", "a captain is on the search for the last surviving son of a family", List.of(Genre.WAR)),
                new Movie("Snow White","seven dwarf rise a orphan child that they found in the woods", List.of(Genre.DOCUMENTARY)),
                new Movie("New Kids Turbo","crazy people from the netherlands decide that their life needs a change",List.of(Genre.HISTORY)),
                new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA)),
                new Movie("We will never be royals", "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood",List.of(Genre.DOCUMENTARY,Genre.MUSICAL)),
                new Movie("Wrong Direction", "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran",List.of(Genre.DRAMA,Genre.MYSTERY)),
                new Movie("The greatest Snowman","a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL)),
                new Movie("Good Boys","A movie about a group of dogs, trying to be good, so they can get praise",List.of(Genre.ACTION,Genre.ADVENTURE)),
                new Movie("Funny Games","Two boys visit a family and try to entertain them, based on a real event",List.of(Genre.BIOGRAPHY,Genre.COMEDY)),
                new Movie("Slow and boring","a group of bicyclist are investigated by an undercover cop",List.of(Genre.CRIME,Genre.FAMILY)),
                new Movie("Chabin in the forrest","A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting",List.of(Genre.FANTASY,Genre.HORROR,Genre.ROMANCE)),
                new Movie("Triathlon - the documentation","One of sports greatest moment as you watch a live recorded triathlon for 7 hours",List.of(Genre.SPORT)),
                new Movie("Dont look down", "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY)),
                new Movie("Complex Instinct","A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time",List.of(Genre.THRILLER)),
                new Movie("The Good, The Bad and the Beautiful","A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often",List.of(Genre.WESTERN)),
                new Movie("This is us", "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", List.of(Genre.DOCUMENTARY)),
                new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY))
        ));

        List<Movie> movieInit = Movie.initializeMovies();

        assertEquals(movies, movieInit);
    }

    @Test
    @DisplayName("Checking the initilizer")
    public void movie_check_initializeMovies_different(){
        List<Movie> expected = new ArrayList<>(Arrays.asList(
                new Movie("Saving Private Jamey Ryan", "a captain is on the search for the last surviving son of a family", List.of(Genre.WAR)),
                new Movie("Snow White","seven dwarf rise a orphan child that they found in the woods", List.of(Genre.DOCUMENTARY)),
                new Movie("New Kids Turbo","crazy people from the netherlands decide that their life needs a change",List.of(Genre.HISTORY)),
                new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA)),
                new Movie("We will never be royals", "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood",List.of(Genre.DOCUMENTARY,Genre.MUSICAL)),
                new Movie("Wrong Direction", "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran",List.of(Genre.DRAMA,Genre.MYSTERY)),
                new Movie("The greatest Snowman","a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL)),
                new Movie("Good Boys","A movie about a group of dogs, trying to be good, so they can get praise",List.of(Genre.ACTION,Genre.ADVENTURE)),
                new Movie("Funny Games","Two boys visit a family and try to entertain them, based on a real event",List.of(Genre.BIOGRAPHY,Genre.COMEDY)),
                new Movie("Slow and boring","a group of bicyclist are investigated by an undercover cop",List.of(Genre.CRIME,Genre.FAMILY)),
                new Movie("Chabin in the forrest","A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting",List.of(Genre.FANTASY,Genre.HORROR,Genre.ROMANCE)),
                new Movie("Triathlon - the documentation","One of sports greatest moment as you watch a live recorded triathlon for 7 hours",List.of(Genre.SPORT)),
                new Movie("Dont look down", "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY)),
                new Movie("This is us", "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", List.of(Genre.DOCUMENTARY)),
                new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY))
        ));

        List<Movie> actual = Movie.initializeMovies();

        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking the title")
    public void movie_check_title(){
        String actual = movieTest.getTitle();
        String expected = "Saving Private Jamey Ryan";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking the decription")
    public void movie_check_descritption(){
        String actual = movieTest.getDescription();
        String expected = "a captain is on the search for the last surviving son of a family";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking the genres")
    public void movie_check_genres(){
        List<Genre> actual = movieTest.getGenres();
        List<Genre> expected = new ArrayList<>(Arrays.asList(
                Genre.WAR
        ));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking toString")
    public void movie_check_toString(){
        String actual = movieTest.toString();
        String expected = "Title: Saving Private Jamey Ryan Description: a captain is on the search for the last surviving son of a familyGenre: [WAR]";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking toString")
    public void movie_check_equals_true(){
        boolean actual = movieTest.equals(movieTest);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Checking toString")
    public void movie_check_equals_false(){
        boolean actual = movieTest.equals(movieTest2);
        boolean expected = false;

        assertEquals(expected, actual);
    }

}
