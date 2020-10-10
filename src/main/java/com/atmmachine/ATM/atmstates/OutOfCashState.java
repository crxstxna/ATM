package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class OutOfCashState implements AtmState {
    private AtmMachine atmMachine;

    public OutOfCashState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public String insertCard() {
        String message = "ATM out of cash, cannot insert card.";
        System.out.println(message);

        return message;
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
    public void withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) {
        System.out.println("ATM out of cash.");
    }
}
