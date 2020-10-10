package com.atmmachine.ATM.errorhandling.exceptions;

public class InvalidPinDigitNumberException extends RuntimeException {
    public InvalidPinDigitNumberException(String message) {
        super(message);
    }

    public InvalidPinDigitNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
