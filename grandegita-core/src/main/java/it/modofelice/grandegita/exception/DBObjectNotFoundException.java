package it.modofelice.grandegita.exception;

public class DBObjectNotFoundException extends RuntimeException {
    public DBObjectNotFoundException(String message) {
        super(message);
    }
}
