package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;

import java.math.BigDecimal;

public class HasValidCardState implements AtmState {
    private AtmMachine atmMachine;

    public HasValidCardState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("The card has already been inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("The session has been cancelled, the card is ejected.");
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
    }

    @Override
    public void insertPin(int enteredPin) {
        int accountAssociatedPIN = 12345;
        if(enteredPin == accountAssociatedPIN) {
            System.out.println("Valid PIN code entered.");
            this.atmMachine.setAtmState(this.atmMachine.getHasValidPinState());
        } else {
            System.out.println("Invalid PIN code entered, the card is ejected.");
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        }

    }

    @Override
    public void withdraw(BigDecimal amount) {
        System.out.println("PIN code not provided yet.");
    }
}
