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
    public void ejectCard() {
        System.out.println("The session has been cancelled, the card is ejected.");
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
    }

    @Override
    public void insertPin(int enteredPin) throws InvalidPinDigitNumberException {
        int accountAssociatedPin = 12345;
        if (String.valueOf(enteredPin).length() != 5) {
            this.handleWrongNoPinDigits();
            throw new InvalidPinDigitNumberException("Invalid number of PIN digits entered.");
        }
        if (enteredPin == accountAssociatedPin) {
            System.out.println("Valid PIN code entered.");
            this.atmMachine.setAtmState(this.atmMachine.getHasValidPinState());
        } else {
            System.out.println("Invalid PIN code entered, the card is ejected.");
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        }
    }

    @Override
    public void withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) {
        System.out.println("PIN code not entered yet.");
    }

    private void handleWrongNoPinDigits() {
        logger.error("Wrong number of PIN digits entered, card is ejected.");
        System.out.println("Wrong number of PIN digits entered.");
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
    }
}
