package com.atmmachine.ATM;

import com.atmmachine.ATM.unitTestExceptions.InvalidPinDigitNumberException;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AtmState {
    void insertCard();
    void ejectCard();
    void insertPin(int enteredPin) throws InvalidPinDigitNumberException;
    void withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash);
}
