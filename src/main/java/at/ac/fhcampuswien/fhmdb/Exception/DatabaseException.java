package at.ac.fhcampuswien.fhmdb.Exception;

public class DatabaseException extends  Exception {
    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException() {
        super();
    }

    public DatabaseException(Exception e) {
        super(e);
    }
}
