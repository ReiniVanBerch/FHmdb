package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;


import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;


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
        assertEquals("Saving Private Ryan", title);
    }





    @Test
    public void filterList() {

    }

    @Test
    public void sortAscFilteredList() {

    }

    @Test
    public void sortDesFilteredList() {

    }

    @Test
    public void sortViewAscending() {

    }

    @Test
    public void sortViewDescending() {

    }

    @Test
    public void unfilterList() {

    }

    @Test
    public void search() {

    }

}