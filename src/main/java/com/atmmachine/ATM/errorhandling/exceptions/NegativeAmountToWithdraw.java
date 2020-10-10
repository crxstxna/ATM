package com.atmmachine.ATM.errorhandling.exceptions;

public class NegativeAmountToWithdraw extends RuntimeException {
    public NegativeAmountToWithdraw(String message) {
        super(message);
    }
}
