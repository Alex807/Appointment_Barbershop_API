package com.AlexBurada.Barbershop.exception;

import org.springframework.http.HttpStatus;

public class DtoNotFoundException extends RuntimeException {

    private final HttpStatus status;

    public DtoNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatusCode() {
        return status;
    }
}
