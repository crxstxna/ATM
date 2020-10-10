package com.atmmachine.ATM.errorhandling;

import com.atmmachine.ATM.errorhandling.exceptions.InvalidPinDigitNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = InvalidPinDigitNumberException.class)
    public ResponseEntity<Object> handleInvalidPinDigitNoException(InvalidPinDigitNumberException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiExceptionModel apiException = new ApiExceptionModel(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, badRequest);
    }
}
