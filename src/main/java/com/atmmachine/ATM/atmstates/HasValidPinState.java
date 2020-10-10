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
    public String ejectCard() {
        String message = "The session has been cancelled, the card is ejected.";
        System.out.println(message);
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        return message;
    }

    @Override
    public String insertPin(int enteredPin) {
        String message = "The PIN code has already been entered.";
        System.out.println(message);
        return message;
    }

    @Override
    public String withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) throws NegativeAmountToWithdraw {
        String message;
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            message = "Negative amount entered. The card is ejected.";
            this.handleNegativeAmountEntered(message);
            throw new NegativeAmountToWithdraw(message);
        }

        if (this.atmMachine.getAvailableCash().compareTo(amount) < 0) {
            message = "ATM does not have enough funds! Card is ejected.";
            System.out.println(message);
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        } else {
            subtractFromAvailableCash.accept(amount);
            message = "Cash withdrawn. The card is ejected.";
            System.out.println(message);
            this.atmMachine.setAtmState(this.atmMachine.getIdleState());
            if (this.atmMachine.getAvailableCash().compareTo(BigDecimal.ZERO) == 0) {
                message = "Cash withdrawn. ATM out of cash.";
                System.out.println(message);
                this.atmMachine.setAtmState(this.atmMachine.getOutOfCashState());
            }
        }
        return message;
    }

    private void handleNegativeAmountEntered(String message) {
        this.atmMachine.setAtmState(this.atmMachine.getIdleState());
        logger.error(message);
        System.out.println(message);
    }
}
