package com.example.webclienttest;

public class BadRequestException extends Exception {
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
