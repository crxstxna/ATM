package com.atmmachine.ATM;

import com.atmmachine.ATM.atmstates.HasValidCardState;
import com.atmmachine.ATM.atmstates.HasValidPinState;
import com.atmmachine.ATM.atmstates.IdleState;
import com.atmmachine.ATM.atmstates.OutOfCashState;
import com.atmmachine.ATM.unitTestExceptions.InvalidPinDigitNumberException;
import com.atmmachine.ATM.unitTestExceptions.NegativeAmountToWithdraw;

import java.math.BigDecimal;

public class AtmMachine {
    private AtmState idleState;
    private AtmState hasValidCardState;
    private AtmState hasValidPinState;
    private AtmState outOfCashState;

    private AtmState atmState;
    private BigDecimal availableCash = BigDecimal.valueOf(10000);

    public AtmMachine() {
        this.idleState = new IdleState(this);
        this.hasValidCardState = new HasValidCardState(this);
        this.hasValidPinState = new HasValidPinState(this);
        this.outOfCashState = new OutOfCashState(this);

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

    public void insertPin(int enteredPin) throws InvalidPinDigitNumberException {
        this.atmState.insertPin(enteredPin);
    }

    public void withdraw(BigDecimal amount) throws NegativeAmountToWithdraw {
        this.atmState.withdraw(amount, this::subtractFromAvailableCash);
    }

    private void subtractFromAvailableCash(BigDecimal amount) {
        this.availableCash = this.availableCash.subtract(amount);
    }

    public BigDecimal getAvailableCash() {
        return availableCash;
    }
    public void setAvailableCash(BigDecimal availableCash) {
        this.availableCash = availableCash;
    }
    public AtmState getIdleState() {
        return idleState;
    }
    public AtmState getHasValidCardState() {
        return hasValidCardState;
    }
    public AtmState getHasValidPinState() {
        return hasValidPinState;
    }
    public AtmState getOutOfCashState() {
        return outOfCashState;
    }
    public AtmState getAtmState() {
        return atmState;
    }
}
