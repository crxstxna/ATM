package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class IdleState implements AtmState {
    private AtmMachine atmMachine;

    public IdleState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public String insertCard() {
        String message = "Entered card is valid!";
        System.out.println(message);
        this.atmMachine.setAtmState(atmMachine.getHasValidCardState());
        return message;
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
    public void withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) {
        System.out.println("No card inserted yet!");
    }
}
