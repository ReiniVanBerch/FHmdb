package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.DisplayName;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test
    @DisplayName("Movie: Testet den Initializier")
    public void movie_test_the_initializer(){
        List<Movie> test =   Movie.initializeMovies();
        assertNotNull(test);
    }
    @Test
    @DisplayName("Movie: Check the getter for Description")
    public void movie_check_if_the_get_desc_returns_a_value(){
        Movie.initializeMovies();
        List<Movie> test =   Movie.initializeMovies();
        String desc =test.get(0).getDescription();
        assertEquals("a captain is on the search for the last surviving son of a family", desc);
    }
    @Test
    @DisplayName("Movie: Check the getter for Title")
    public void movie_check_if_the_get_title_returns_a_value(){
        Movie.initializeMovies();
        List<Movie> test =   Movie.initializeMovies();
        String title =test.get(0).getTitle();
        assertEquals("Saving Private Jamey Ryan", title);
    }

    //checks toString method

    //checks equals method


    @Test
    @DisplayName("checks if list is filtered without having to consider capitalisation")
    public void check_if_list_is_filtered_without_capitalisation_accuracy() {
        HomeController test = new HomeController();
        test.initializeLogic();
        String testQuery = "di";
        List<Movie> actualList = test.filterSearchField(testQuery, Movie.initializeMovies());
        List<Movie> expectedList = new ArrayList<>();
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortAscending(actual);
        expectedList.add(new Movie("Wrong Direction", "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran",List.of(Genre.DRAMA,Genre.MYSTERY)));
        expectedList.add(new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY)));
        expectedList.add(new Movie("The greatest Snowman","a large snowman sings in a movie that is set in an ice world, where everybody is different, but also accepted",List.of(Genre.DRAMA,Genre.ANIMATION,Genre.MUSICAL)));
        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        test.sortAscending(expected);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("checks if list is filtered by a genre")
    public void check_if_list_filters_by_genre() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = test.filterGenre(Genre.DOCUMENTARY, Movie.initializeMovies());
        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("Snow White","seven dwarf rise a orphan child that they found in the woods", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA)));
        expectedList.add(new Movie("We will never be royals", "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood",List.of(Genre.DOCUMENTARY,Genre.MUSICAL)));
        expectedList.add(new Movie("This is us", "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY)));

        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortAscending(actual);
        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        test.sortAscending(expected);

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("checks if just the filtered list is sorted in ascending order")
    public void check_if_filtered_list_is_ascending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = test.filterGenre(Genre.DOCUMENTARY, Movie.initializeMovies());
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortAscending(actual);

        List<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY)));
        expectedList.add(new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA)));
        expectedList.add(new Movie("Snow White","seven dwarf rise a orphan child that they found in the woods", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("This is us", "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("We will never be royals", "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood",List.of(Genre.DOCUMENTARY,Genre.MUSICAL)));

        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks if just the filtered list is sorted in descending order")
    public void check_if_filtered_list_is_descending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = test.filterGenre(Genre.DOCUMENTARY, Movie.initializeMovies());
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);
        test.sortDescending(actual);

        List<Movie> expectedList = new ArrayList<>();

        expectedList.add(new Movie("We will never be royals", "a family of five is on the search for their ancestry, because their grandparents always lied to them about being from royal blood",List.of(Genre.DOCUMENTARY,Genre.MUSICAL)));
        expectedList.add(new Movie("This is us", "A look at Niall, Zayn, Liam, Louis, and Harry's meteoric rise to fame, from their humble hometown beginnings and competing on the X-Factor, to conquering the world and performing at London's famed O2 Arena.", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("Snow White","seven dwarf rise a orphan child that they found in the woods", List.of(Genre.DOCUMENTARY)));
        expectedList.add(new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA)));
        expectedList.add(new Movie("All Of Those Voices", "A documentary film about English singer-songwriter Louis Tomlinson's personal journey of transitioning from a member of One Direction to a solo musician.", List.of(Genre.BIOGRAPHY, Genre.DOCUMENTARY)));

        ObservableList<Movie> expected = FXCollections.observableArrayList(expectedList);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("checks if list is sorted in ascending order")
    public void check_if_unfiltered_list_is_ascending() {
        HomeController test = new HomeController();
        test.initializeLogic();
        List<Movie> actualList = Movie.initializeMovies();
        ObservableList<Movie> actual = FXCollections.observableArrayList(actualList);


    }

    @Test
    @DisplayName("checks if list is sorted in descending order")
    public void check_if_unfiltered_list_is_descending() {

    }

    @Test
    @DisplayName("checks if initial list is sorted in ascending order")
    public void check_if_initial_list_is_ascending() {

    }

    @Test
    @DisplayName("checks if a filtered list can be reverted back in its original state")
    public void check_if_filtered_list_is_unfiltered_again() {

    }

    @Test
    @DisplayName("checks if searching for a word turns up all possible results")
    public void check_if_searching_works() {
    }
}