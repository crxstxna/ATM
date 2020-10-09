package com.atmmachine.ATM;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AtmState {
    void insertCard();
    void ejectCard();
    void insertPin(int enteredPin);
    void withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromAvailableCash);
}
