package at.ac.fhcampuswien.fhmdb.Exception;

public class MovieApiException extends Exception {
    public MovieApiException(String message) {
        super(message);
    }

    public MovieApiException() {
        super();
    }

    public MovieApiException(Exception e) {
        super(e);
    }
}
