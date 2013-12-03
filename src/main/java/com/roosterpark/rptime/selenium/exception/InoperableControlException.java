package com.roosterpark.rptime.selenium.exception;

/**
 * User: John
 * Date: 12/3/13
 * Time: 9:35 AM
 */
public class InoperableControlException extends RuntimeException {

    public InoperableControlException() {
        super();
    }

    public InoperableControlException(String message) {
        super(message);
    }

    public InoperableControlException(Throwable cause) {
        super(cause);
    }

    public InoperableControlException(String message, Throwable cause) {
        super(message, cause);
    }

}
