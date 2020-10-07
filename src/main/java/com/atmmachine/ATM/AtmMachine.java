package com.atmmachine.ATM;

import com.atmmachine.ATM.atmstates.IdleState;

import java.math.BigDecimal;

public class AtmMachine {
    AtmState idleState;

    private AtmState atmState;
    private BigDecimal availableCash = BigDecimal.valueOf(10000);

    public AtmMachine() {
        idleState = new IdleState(this);

        this.atmState = idleState;
    }

    public void setAtmState(AtmState newAtmState) {
        this.atmState = newAtmState;
    }

    public void insertCard() {
        this.atmState.insertCard();
    }

    public void ejectCard() {
        this.atmState.ejectCard();
    }

    public void insertPin(int pinEntered) {
        this.atmState.insertPin(pinEntered);
    }

    public void withdraw(BigDecimal amount) {
        this.atmState.withdraw(amount);
    }

    public AtmState getIdleState() {
        return idleState;
    }
}
