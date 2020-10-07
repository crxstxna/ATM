package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;

import java.math.BigDecimal;

public class IdleState implements AtmState {
    AtmMachine atmMachine;

    public IdleState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Entered card is valid!");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card inserted yet!");
    }

    @Override
    public void insertPin(int enteredPin) {
        System.out.println("No card inserted yet!");
    }

    @Override
    public void withdraw(BigDecimal amount) {
        System.out.println("No card inserted yet!");
    }
}
