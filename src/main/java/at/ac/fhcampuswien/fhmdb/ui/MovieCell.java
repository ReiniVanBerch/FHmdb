package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MovieCell extends ListCell<Movie> {
    private final Label title = new Label();
    private final Label detail = new Label();
    private final Label genres = new Label();
    private final Label releaseyear = new Label();
    private final Label rating = new Label();
    private final VBox layout = new VBox(title, detail, genres,releaseyear,rating);

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setGraphic(null);
            setText(null);
        } else {
            this.getStyleClass().add("movie-cell");

            title.setText(movie.getTitle());

            detail.setText(
                    movie.getDescription() != null
                            ? movie.getDescription()
                            : "No description available"
            );



            genres.setText(
                    !movie.getGenres().isEmpty()
                    ?       movie.getGenres().toString().replace("[", "").replace("]", "")
                    :       "No genres available"
            );

            releaseyear.setText(
                    movie.getReleaseYear() != 0
                            ?       "Releaseyear: " + movie.getReleaseYear()
                            :       "No Releaseyear available"
            );
            rating.setText(
                    movie.getRating() != 0
                            ?       "Rating: " + movie.getRating()
                            :       "No Rating available"
            );



            // color scheme
            title.getStyleClass().add("text-yellow");
            detail.getStyleClass().add("text-white");
            genres.getStyleClass().add("text-white");
            releaseyear.getStyleClass().add("text-white");
            rating.getStyleClass().add("text-white");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

            // layout
            title.fontProperty().set(title.getFont().font(20));

            detail.setMaxWidth(this.getScene().getWidth() - 30);
            detail.setWrapText(true);

            genres.setMaxWidth(this.getScene().getWidth() - 30);
            genres.setWrapText(true);

            releaseyear.setMaxWidth(this.getScene().getWidth() - 30);
            releaseyear.setWrapText(true);
            rating.setMaxWidth(this.getScene().getWidth() - 30);
            rating.setWrapText(true);

            layout.setPadding(new Insets(10));
            layout.spacingProperty().set(10);
            layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);
            setGraphic(layout);
        }
    }
}

