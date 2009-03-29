package org.aurifa.demo.strutter.exception;

/**
 * NonExistentUserException.
 *
 * @author Rene Gielen
 */
public class NonExistentUserException extends Exception {

    public NonExistentUserException() {
        super();
    }

    public NonExistentUserException( String message ) {
        super(message);
    }

    public NonExistentUserException( String message, Throwable cause ) {
        super(message, cause);
    }

    public NonExistentUserException( Throwable cause ) {
        super(cause);
    }
}
