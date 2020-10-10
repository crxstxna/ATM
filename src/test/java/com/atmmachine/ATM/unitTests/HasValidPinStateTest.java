package com.atmmachine.ATM.unitTests;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.atmstates.IdleState;
import com.atmmachine.ATM.atmstates.OutOfCashState;
import com.atmmachine.ATM.errorhandling.exceptions.NegativeAmountToWithdraw;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class HasValidPinStateTest {

    private AtmMachine atmMachine;

    @Before
    public void setUp() {
        atmMachine = new AtmMachine();
        atmMachine.insertCard();
        atmMachine.insertPin(12345);
    }

    @Test
    public void withdrawTest() throws NegativeAmountToWithdraw {
        this.atmMachine.withdraw(BigDecimal.valueOf(100));
        assertTrue(this.atmMachine.getAtmState() instanceof IdleState);
    }

    @Test
    public void notEnoughFundsTest() throws NegativeAmountToWithdraw {
        this.atmMachine.withdraw(BigDecimal.valueOf(10001));
        assertTrue(this.atmMachine.getAtmState() instanceof IdleState);
    }

    @Test
    public void atmOutOfCashTest() throws NegativeAmountToWithdraw {
        this.atmMachine.withdraw(BigDecimal.valueOf(10000));
        this.atmMachine.insertCard();
        assertTrue(this.atmMachine.getAtmState() instanceof OutOfCashState);
    }

    @Test (expected = NegativeAmountToWithdraw.class)
    public void negativeAmountToWithdrawTest() throws NegativeAmountToWithdraw {
        this.atmMachine.withdraw(BigDecimal.valueOf(-100));
    }
}