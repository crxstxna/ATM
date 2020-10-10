package com.atmmachine.ATM.controllers;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.errorhandling.exceptions.InvalidPinDigitNumberException;
import com.atmmachine.ATM.errorhandling.exceptions.NegativeAmountToWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/ATM")
public class AtmController {

    @Autowired
    private AtmMachine atmMachine;

    @GetMapping(value = "/insertCard", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> insertCard() {
        String message = atmMachine.insertCard();
        return new ResponseEntity<>(new ResponseModel(message, HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping(value = "/insertPin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> insertPin(@RequestParam int pin) {
        String message;
        try {
            message = atmMachine.insertPin(pin);
        } catch (InvalidPinDigitNumberException e) {
            return new ResponseEntity<>(new ResponseModel(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseModel(message, HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping(value = "/withdraw", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> withdraw(@RequestParam BigDecimal amount) {
        String message;
        try {
            message = this.atmMachine.withdraw(amount);
        } catch (NegativeAmountToWithdraw e) {
            return new ResponseEntity<>(new ResponseModel(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseModel(message, HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping(value = "/ejectCard")
    public ResponseEntity<Object> ejectCard() {
        String message = atmMachine.ejectCard();
        return new ResponseEntity<>(new ResponseModel(message, HttpStatus.OK), HttpStatus.OK);
    }
}
