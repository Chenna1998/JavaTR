package com.exception;

public class MarksException extends Exception{

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public MarksException(String message) {
        this.message = message;
    }
}
