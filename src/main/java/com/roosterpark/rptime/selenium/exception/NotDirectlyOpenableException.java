package com.roosterpark.rptime.selenium.exception;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:01 PM
 *
 * Exception for pages that should not be directly opened
 */
public class NotDirectlyOpenableException extends RuntimeException {

    public NotDirectlyOpenableException() {
        super();
    }

    public NotDirectlyOpenableException(String message) {
        super(message);
    }

    public NotDirectlyOpenableException(Throwable cause) {
        super(cause);
    }

    public NotDirectlyOpenableException(String message, Throwable cause) {
        super(message, cause);
    }

}
