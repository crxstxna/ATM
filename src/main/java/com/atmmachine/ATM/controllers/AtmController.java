package com.atmmachine.ATM.controllers;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.errorhandling.ApiExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

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
        try {
            atmMachine.insertPin(pin);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseModel("pin corect", HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping(value = "/ejectCard")
    public void ejectCard() {
        atmMachine.ejectCard();
    }
}
