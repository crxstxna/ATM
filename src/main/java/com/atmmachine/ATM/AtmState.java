package com.atmmachine.ATM;

import java.math.BigDecimal;

public interface AtmState {
    void insertCard();
    void ejectCard();
    void insertPin(int enteredPin);
    void withdraw(BigDecimal amount);
}
