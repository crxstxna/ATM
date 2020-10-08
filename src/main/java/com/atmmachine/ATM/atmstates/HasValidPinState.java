package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;

import java.math.BigDecimal;

public class HasValidPinState implements AtmState {
    private AtmMachine atmMachine;

    public HasValidPinState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("The card has already been inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("The session has been cancelled, the card is ejected.");
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
    }

    @Override
    public void insertPin(int enteredPin) {
        System.out.println("The PIN code has already been entered.");
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (this.atmMachine.getAvailableCash().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("ATM does not have enough funds! Card is ejected.");
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        } else {
            this.atmMachine.setAvailableCash(this.atmMachine.getAvailableCash().subtract(amount));
            System.out.println("Cash withdrawn.");
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
            if (this.atmMachine.getAvailableCash().compareTo(BigDecimal.ZERO) == 0) {
                System.out.println("ATM out of cash.");
                this.atmMachine.setAtmState(this.atmMachine.getOutOfCashState());
            }
        }
    }
}
