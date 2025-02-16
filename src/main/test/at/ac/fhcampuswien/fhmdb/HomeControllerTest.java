package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;


import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test
    @DisplayName("Testet den Initializier")
    public void test_the_initializer(){
        List<Movie> test =   Movie.initializeMovies();
        assertNotNull(test);
    }
    @Test
    @DisplayName("Check the getter for Description")
    public void check_if_the_get_desc_returns_a_value(){
        Movie.initializeMovies();
        List<Movie> test =   Movie.initializeMovies();
        String desc =test.get(0).getDescription();
        assertEquals("a captain is on the search for the last surviving son of a family", desc);
    }
    @Test
    @DisplayName("Check the getter for Title")
    public void check_if_the_get_title_returns_a_value(){
        Movie.initializeMovies();
        List<Movie> test =   Movie.initializeMovies();
        String title =test.get(0).getTitle();
        assertEquals("Saving Private Ryan", title);
    }

    //checks toString method

    //checks equals method

/*
//TODO: what if we have mib 1, 2 & 3
    @Test
    @DisplayName("checks if the list is filtered by searching a title name")
    public void check_if_list_is_filtered_by_title() {
        HomeController test = new HomeController();

        Movie mib = new Movie("Men in Black","a heavy metal band tours through norway and tries to find love for pop on the way to the hardest metal festival of their life",List.of(Genre.DOCUMENTARY,Genre.DRAMA));

        List<Movie> moviesList = Movie.initializeMovies();
        ObservableList<Movie> comparableList = FXCollections.observableArrayList();
        for (Movie m : moviesList) {
            if (m.getTitle().contains("Men in Black")) {
                comparableList.add(m);
            }
        }
//        if () {
//
//        }



    }

 */

    /*
    @Test
    @DisplayName("checks if list is filtered by searching a summary text")
    public void check_if_list_is_filtered_by_searching_summaryText() {
        HomeController test = new HomeController();
        //test.


    }
     */

    @Test
    @DisplayName("checks if list is filtered without having to consider capitalisation")
    public void check_if_list_is_filtered_without_capitalisation_accuracy() {
        HomeController test = new HomeController();
        //test.
    }

    @Test
    @DisplayName("checks if list is filtered by a genre")
    public void check_if_list_filters_by_genre() {

    }

    @Test
    @DisplayName("checks if just the filtered list is sorted in ascending order")
    public void check_if_filtered_list_is_ascending() {

    }

    @Test
    @DisplayName("checks if just the filtered list is sorted in descending order")
    public void check_if_filtered_list_is_descending() {

    }

    @Test
    @DisplayName("checks if list is sorted in ascending order")
    public void check_if_unfiltered_list_is_ascending() {

    }

    @Test
    @DisplayName("checks if list is sorted in descending order")
    public void check_if_unfiltered_list_is_descending() {

    }

    @Test
    @DisplayName("checks if a filtered list can be reverted back in its original state")
    public void check_if_filtered_list_is_unfiltered_again() {

    }

    @Test
    @DisplayName("checks if searching for a word turn up allaaaa7uui results")
    public void check_if_searching_works() {

    }

}