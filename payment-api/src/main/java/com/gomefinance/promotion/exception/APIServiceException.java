package com.gomefinance.promotion.exception;

@SuppressWarnings("serial")
public class APIServiceException extends RuntimeException {

    public APIServiceException() {
        super();
    }

    public APIServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIServiceException(String message) {
        super(message);
    }

    public APIServiceException(Throwable cause) {
        super(cause);
    }

}
