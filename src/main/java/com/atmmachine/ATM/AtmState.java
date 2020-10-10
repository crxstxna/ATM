package com.atmmachine.ATM;

import com.atmmachine.ATM.errorhandling.exceptions.InvalidPinDigitNumberException;
import com.atmmachine.ATM.errorhandling.exceptions.NegativeAmountToWithdraw;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AtmState {
    String insertCard();
    String ejectCard();
    String insertPin(int enteredPin) throws InvalidPinDigitNumberException;
    String withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) throws NegativeAmountToWithdraw;
}