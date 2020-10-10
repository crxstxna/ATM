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
    public String ejectCard() {
        String message = "No card inserted yet!";
        System.out.println(message);
        return message;
    }

    @Override
    public String insertPin(int enteredPin) {
        String message = "No card inserted yet!";
        System.out.println(message);
        return message;
    }

    @Override
    public String withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) {
        String message = "No card inserted yet!";
        System.out.println(message);
        return message;
    }
}
