package com.bemach.tdd.bankapp;

import java.math.BigDecimal;

import org.junit.Test;

import com.bemach.tdd.bankapp.Account;
import com.bemach.tdd.bankapp.EmailNotifier;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    public void itCreatesACheckingAccountWithZeroBalance() {

        Account testSubject = new Account();

        testSubject.setFirstName("Jane");
        testSubject.setLastName("Doe");
        testSubject.setupAccount();

        assertNotNull(testSubject.getAccountNumber());
        assertEquals(BigDecimal.ZERO, testSubject.getBalance());
    }

    @Test
    public void itDepositsToEmptyAccount() {

        Account testSubject = new Account();
        testSubject.deposit(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), testSubject.getBalance());
    }

    @Test
    public void itDepositsToAccountWithSomeBalance() {

        Account testSubject = new Account();

        testSubject.deposit(BigDecimal.valueOf(100));
        testSubject.deposit(BigDecimal.valueOf(50));

        assertEquals(BigDecimal.valueOf(150), testSubject.getBalance());
    }

    @Test(expected=IllegalArgumentException.class)
    public void itWontAllowNegativeDeposits() {

        Account testSubject = new Account();

        testSubject.deposit(BigDecimal.valueOf(-50));
    }

    @Test
    public void itDebitsOnceFromAccountWithSomeBalance() {

        Account testSubject = new Account();

        testSubject.deposit(BigDecimal.valueOf(100));
        testSubject.withdraw(BigDecimal.valueOf(10.50));

        assertEquals(BigDecimal.valueOf(89.50), testSubject.getBalance());
    }

    @Test
    public void itDebitsFromAccountWithSomeBalanceMultipleTimes() {

        Account testSubject = new Account();

        testSubject.deposit(BigDecimal.valueOf(100));
        testSubject.withdraw(BigDecimal.valueOf(10.50));
        testSubject.withdraw(BigDecimal.valueOf(25));

        assertEquals(BigDecimal.valueOf(64.50), testSubject.getBalance());
    }


//    @Test
//    public void itSendsAnEmailNotificationWhenTryingToDebitFromAccountWithInadequateFunds() {
//
//        Account testSubject = spy(new Account());
//        testSubject.deposit(BigDecimal.valueOf(100));
//
//        EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);
//        doReturn(true).when(mockEmailNotifier).sendMessage(anyString(), anyString(), anyString(), anyString());
//
//        doReturn(mockEmailNotifier).when(testSubject).getEmailNotifier();
//
//        testSubject.withdraw(BigDecimal.valueOf(120));
//
//        verify(mockEmailNotifier).sendMessage("service@bank.com", "joe@somewhere.com", "Insufficient funds", "blah blah blah");
//        assertEquals(BigDecimal.valueOf(100), testSubject.getBalance());
//    }

}
