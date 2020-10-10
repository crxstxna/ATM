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
    public String ejectCard() {
        String message = "ATM out of cash.";
        System.out.println(message);
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        return message;
    }

    @Override
    public String insertPin(int enteredPin) {
        String message = "ATM out of cash.";
        System.out.println(message);
        return message;
    }

    @Override
    public String withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) {
        String message = "ATM out of cash.";
        System.out.println(message);
        return message;
    }
}
