package com.atmmachine.ATM;

import com.atmmachine.ATM.atmstates.HasValidCardState;
import com.atmmachine.ATM.atmstates.IdleState;

import java.math.BigDecimal;

public class AtmMachine {
    private AtmState idleState;
    private AtmState hasValidCardState;

    private AtmState atmState;
    private BigDecimal availableCash = BigDecimal.valueOf(10000);

    public AtmMachine() {
        this.idleState = new IdleState(this);
        this.hasValidCardState = new HasValidCardState(this);

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
    public AtmState getHasValidCardState() {
        return hasValidCardState;
    }
}
