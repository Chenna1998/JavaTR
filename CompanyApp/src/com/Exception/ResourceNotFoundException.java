package com.Exception;

public class ResourceNotFoundException extends Exception{

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ResourceNotFoundException(String message) {
        super();
        this.message = message;
    }
}
