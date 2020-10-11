package com.atmmachine.ATM.atmstates;

import com.atmmachine.ATM.AtmMachine;
import com.atmmachine.ATM.errorhandling.exceptions.InvalidPinDigitNumberException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HasValidCardStateTest {

    private AtmMachine atmMachine;

    @Before
    public void setUp() {
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