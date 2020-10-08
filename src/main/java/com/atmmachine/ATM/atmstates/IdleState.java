package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;

import java.math.BigDecimal;

public class IdleState implements AtmState {
    private AtmMachine atmMachine;

    public IdleState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Entered card is valid!");
        this.atmMachine.setAtmState(atmMachine.getHasValidCardState());
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
