package com.atmmachine.ATM;

import com.atmmachine.ATM.errorhandling.exceptions.InvalidPinDigitNumberException;
import com.atmmachine.ATM.errorhandling.exceptions.NegativeAmountToWithdraw;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AtmState {
    String insertCard();
    void ejectCard();
    void insertPin(int enteredPin) throws InvalidPinDigitNumberException;
    void withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash) throws NegativeAmountToWithdraw;
}
