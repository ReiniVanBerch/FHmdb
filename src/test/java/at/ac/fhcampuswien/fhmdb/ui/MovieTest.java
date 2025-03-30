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
                new Movie("1","Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,3.7 ),
                new Movie("2","Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ),
                new Movie("3","New Kids Turbo",List.of(Genre.HISTORY),2002,"crazy people from the netherlands decide that their life needs a change","URL3", 133,1.2),
                new Movie("4","Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4),
                new Movie("5","We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4),
                new Movie("6","Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5),
                new Movie("7","The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5),
                new Movie("8","Good Boys",List.of(Genre.ACTION,Genre.ADVENTURE),2010,"A movie about a group of dogs, trying to be good, so they can get praise","URL7",155,2.2),
                new Movie("9","Funny Games",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2024,"Two boys visit a family and try to entertain them, based on a real event","URL8",129,5),
                new Movie("10","Slow and boring",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2025,"a group of bicyclist are investigated by an undercover cop","URL9",111,3),
                new Movie("11","Chabin in the forrest",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2016,"A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting","URL10",22,3),
                new Movie("12","Triathlon - the documentation",List.of(Genre.SPORT),2009,"One of sports greatest moment as you watch a live recorded triathlon for 7 hours","URL11",475,1),
                new Movie("13","Dont look down",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY),2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth","URL12",112,2),
                new Movie("14","Complex Instinct",List.of(Genre.THRILLER),2004,"A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time","URL13",140,3),
                new Movie("15","The Good, The Bad and the Beautiful",List.of(Genre.WESTERN),1975,"A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often","URL14",190,4.5),
                new Movie("16","This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ),
                new Movie("17","All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 )


        ));

        List<Movie> movieInit = Movie.initializeMovies();

        assertEquals(movies, movieInit);
    }

    @Test
    @DisplayName("Checking the initilizer")
    public void movie_check_initializeMovies_different(){
        List<Movie> expected = new ArrayList<>(Arrays.asList(
                new Movie("1","Saving Private Jamey Ryan",List.of(Genre.WAR),1998, "a captain is on the search for the last surviving son of a family", "URL1",220,3.7 ),
                new Movie("2","Snow White",List.of(Genre.DOCUMENTARY),1970,"seven dwarf rise a orphan child that they found in the woods","URL2", 123,2.1 ),
                new Movie("3","New Kids Turbo",List.of(Genre.HISTORY),2002,"crazy people from the netherlands decide that their life needs a change","URL3", 133,1.2),
                new Movie("4","Men in Black",List.of(Genre.DOCUMENTARY,Genre.DRAMA),1999,"a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life","URL4",110,2.4),
                new Movie("5","We will never be royals",List.of(Genre.DOCUMENTARY,Genre.MUSICAL),2008, "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood","URL5",108,3.4),
                new Movie("6","Wrong Direction",List.of(Genre.DOCUMENTARY,Genre.MUSICAL), 2022, "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran","URL6",90,4.5),
                new Movie("7","The greatest Snowman",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL),2007,"a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted","URL7", 120,3.5),
                new Movie("8","Good Boys",List.of(Genre.ACTION,Genre.ADVENTURE),2010,"A movie about a group of dogs, trying to be good, so they can get praise","URL7",155,2.2),
                new Movie("9","Funny Games",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2024,"Two boys visit a family and try to entertain them, based on a real event","URL8",129,5),
                new Movie("10","Slow and boring",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2025,"a group of bicyclist are investigated by an undercover cop","URL9",111,3),
                new Movie("11","Chabin in the forrest",List.of(Genre.BIOGRAPHY,Genre.COMEDY),2016,"A romantiv weekend turns into the horror of a century when the gargoyles in the hill wake up for their annual meeting","URL10",22,3),
                new Movie("12","Triathlon - the documentation",List.of(Genre.SPORT),2009,"One of sports greatest moment as you watch a live recorded triathlon for 7 hours","URL11",475,1),
                new Movie("13","Dont look down",List.of(Genre.SCIENCE_FICTION,Genre.HISTORY),2002, "A billionaire wants to conquer the inner earth, as he realisied that mars is very far from earth","URL12",112,2),
                new Movie("14","Complex Instinct",List.of(Genre.THRILLER),2004,"A detective is searching for a murderer, the suspect is an introverted computer scientist that plays games all the time","URL13",140,3),
                new Movie("15","The Good, The Bad and the Beautiful",List.of(Genre.WESTERN),1975,"A group of cowboys are on the search for the treasure of the confederacy, as they get nearer to the treasure, their paths cross even more often","URL14",190,4.5),
                new Movie("16","This is us",List.of(Genre.DOCUMENTARY),2013, "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.","https://en.wikipedia.org/wiki/File:One_Direction_This_is_Us_Theatrical_Poster.jpg",92,4.7 ),
                new Movie("17","All Of Those Voices",List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY),2023, "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.","https://upload.wikimedia.org/wikipedia/en/f/f5/All_of_those_voices.jpg",108,4.3 )
        ));

        List<Movie> actual = Movie.initializeMovies();

        assertEquals(expected, actual);
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
