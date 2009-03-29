package org.aurifa.demo.strutter.exception;

/**
 * UserAlreadyExistentException.
 *
 * @author Rene Gielen
 */
public class UserAlreadyExistentException extends Exception {

    public UserAlreadyExistentException() {
        super();
    }

    public UserAlreadyExistentException( String message ) {
        super(message);
    }

    public UserAlreadyExistentException( String message, Throwable cause ) {
        super(message, cause);
    }

    public UserAlreadyExistentException( Throwable cause ) {
        super(cause);
    }
}
