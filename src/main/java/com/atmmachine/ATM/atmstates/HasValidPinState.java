package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.AtmState;
import com.atmmachine.ATM.errorhandling.exceptions.NegativeAmountToWithdraw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class HasValidPinState implements AtmState {
    private AtmMachine atmMachine;
    Logger logger = LogManager.getLogger(HasValidCardState.class.getName());

    public HasValidPinState(AtmMachine newAtmMachine) {
        this.atmMachine = newAtmMachine;
    }

    @Override
    public String insertCard() {
        String message = "The card has already been inserted.";
        System.out.println(message);
        return message;
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
    public void withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) throws NegativeAmountToWithdraw {
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            logger.error("Negative amount to withdraw entered.");
            throw new NegativeAmountToWithdraw();
        }

        if (this.atmMachine.getAvailableCash().compareTo(amount) < 0) {
            System.out.println("ATM does not have enough funds! Card is ejected.");
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        } else {
            subtractFromAvailableCash.accept(amount);
            System.out.println("Cash withdrawn.");
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
            if (this.atmMachine.getAvailableCash().compareTo(BigDecimal.ZERO) == 0) {
                System.out.println("ATM out of cash.");
                this.atmMachine.setAtmState(this.atmMachine.getOutOfCashState());
            }
        }
    }
}
