package com.atmmachine.ATM.controllers;

import org.springframework.http.HttpStatus;

public class ResponseModel {
    private final String message;
    private final HttpStatus httpStatus;

    public ResponseModel(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
