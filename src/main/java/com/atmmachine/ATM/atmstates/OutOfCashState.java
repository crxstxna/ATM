package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;

import java.math.BigDecimal;

public class OutOfCashState implements AtmState {
    private AtmMachine atmMachine;

    public OutOfCashState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("ATM out of cash.");
    }

    @Override
    public void ejectCard() {
        System.out.println("ATM out of cash.");
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
    }

    @Override
    public void insertPin(int enteredPin) {
        System.out.println("ATM out of cash.");
    }

    @Override
    public void withdraw(BigDecimal amount) {
        System.out.println("ATM out of cash.");
    }
}