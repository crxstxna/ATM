package com.atmmachine.ATM.errorhandling;

import com.atmmachine.ATM.controllers.ResponseModel;
import com.atmmachine.ATM.errorhandling.exceptions.InvalidPinDigitNumberException;
import com.atmmachine.ATM.errorhandling.exceptions.NegativeAmountToWithdraw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = InvalidPinDigitNumberException.class)
    public ResponseEntity<Object> handleInvalidPinDigitNoException(InvalidPinDigitNumberException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ResponseModel responseModel = new ResponseModel(e.getMessage(), badRequest);
        return new ResponseEntity<>(responseModel, badRequest);
    }

    @ExceptionHandler(value = NegativeAmountToWithdraw.class)
    public ResponseEntity<Object> handleNegativeAmountToWithdrawException(NegativeAmountToWithdraw e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ResponseModel responseModel = new ResponseModel(e.getMessage(), badRequest);
        return new ResponseEntity<>(responseModel, badRequest);
    }
}
