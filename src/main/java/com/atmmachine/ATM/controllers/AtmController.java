package com.atmmachine.ATM.controllers;

import com.atmmachine.ATM.AtmMachine;
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

    @PostMapping (value = "/insertPin/{pin}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> insertPin(@PathVariable int pin) {
        String message;
        message = atmMachine.insertPin(pin);
        return new ResponseEntity<>(new ResponseModel(message, HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping(value = "/withdraw/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> withdraw(@PathVariable BigDecimal amount) {
        String message;
        message = this.atmMachine.withdraw(amount);
        return new ResponseEntity<>(new ResponseModel(message, HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping(value = "/ejectCard")
    public ResponseEntity<Object> ejectCard() {
        String message = atmMachine.ejectCard();
        return new ResponseEntity<>(new ResponseModel(message, HttpStatus.OK), HttpStatus.OK);
    }
}
