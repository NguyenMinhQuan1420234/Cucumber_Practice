package com.tms.cucumber.utils;

public class ParsingJsonException extends RuntimeException{
    public ParsingJsonException(String message) {
        super(message);
    }

    public ParsingJsonException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
