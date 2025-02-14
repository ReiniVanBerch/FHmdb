package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;


import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test
    @DisplayName("Testet den Initializier")
    public void test_the_nitializer(){
        List<Movie> test =   Movie.initializeMovies();
        assertNotNull(test);


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