package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;
import com.atmmachine.ATM.errorhandling.exceptions.InvalidPinDigitNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class HasValidCardState implements AtmState {
    private AtmMachine atmMachine;
    Logger logger = LogManager.getLogger(HasValidCardState.class.getName());

    public HasValidCardState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public String insertCard() {
        String message = "The card has already been inserted.";
        System.out.println(message);

        return message;
    }

    @Override
    public String ejectCard() {
        String message = "The session has been cancelled, the card is ejected.";
        System.out.println(message);
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        return message;
    }

    @Override
    public String insertPin(int enteredPin) throws InvalidPinDigitNumberException {
        int accountAssociatedPin = 12345;
        String message;
        if (String.valueOf(enteredPin).length() != 5) {
            message = "Invalid number of PIN digits entered, the card is ejected.";
            this.handleWrongNoPinDigits(message);
            throw new InvalidPinDigitNumberException(message);
        }
        if (enteredPin == accountAssociatedPin) {
            message = "Valid PIN code entered.";
            System.out.println(message);
            this.atmMachine.setAtmState(this.atmMachine.getHasValidPinState());
        } else {
            message = "Invalid PIN code entered, the card is ejected.";
            System.out.println(message);
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        }
        return message;
    }

    @Override
    public String withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) {
        String message = "PIN code not entered yet.";
        System.out.println(message);
        return message;
    }

    private void handleWrongNoPinDigits(String message) {
        logger.error(message);
        System.out.println(message);
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
    }
}