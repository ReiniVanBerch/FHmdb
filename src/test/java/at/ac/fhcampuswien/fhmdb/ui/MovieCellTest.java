package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.scene.control.ListCell;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieCellTest {
    @Test
    @DisplayName("MoviCell: Updating Item")
    public void updatingItem() {
        Movie movie = new Movie("Wrong Direction",
                    "two fashion-loving formular 1 drivers search for a way out of the f1 circus, sadly they trust the wrong fashion bran",
                            List.of(Genre.DRAMA,Genre.MYSTERY));

        ListCell<Movie> cell = new MovieCell();


/*        Method method = Movie.class.getDeclaredMethod("privateMethod", int.class, int.class);
        method.setAccessible(true); // Allow access to private method
        int result = (int) method.invoke(obj, 2, 3);
        assertEquals(5, result);
        movie.get
        cell.updateItem(movie, false);*/


    }

}
