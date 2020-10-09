package com.atmmachine.ATM.unitTests;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.atmstates.HasValidPinState;
import com.atmmachine.ATM.atmstates.IdleState;
import com.atmmachine.ATM.unitTestExceptions.InvalidPinDigitNumberException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HasValidCardStateTest {

    private AtmMachine atmMachine;

    @Before
    public void setUp() throws Exception {
        atmMachine = new AtmMachine();
        atmMachine.insertCard();
    }

    @Test
    public void insertValidPinTest() throws InvalidPinDigitNumberException {
        atmMachine.insertPin(12345);
        assertTrue(atmMachine.getAtmState() instanceof HasValidPinState);
    }

    @Test
    public void insertInvalidPinTest() throws InvalidPinDigitNumberException {
        atmMachine.insertPin(54321);
        assertTrue(atmMachine.getAtmState() instanceof IdleState);
    }

    @Test
    public void ejectCardTest() {
        atmMachine.ejectCard();
        assertTrue(atmMachine.getAtmState() instanceof IdleState);
    }

    @Test (expected = InvalidPinDigitNumberException.class)
    public void pinBoundaryTest() throws InvalidPinDigitNumberException {
        atmMachine.insertPin(123);
    }
}