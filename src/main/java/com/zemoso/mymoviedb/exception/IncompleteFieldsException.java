package com.zemoso.mymoviedb.exception;


public class IncompleteFieldsException extends RuntimeException {

    public IncompleteFieldsException(String message) {
        super(message);
    }

    public IncompleteFieldsException(String message, Throwable cause) {
        super(message, cause);
    }
}
