package com.exception;

public class TransferException extends Exception{

    private String message;

    public TransferException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
