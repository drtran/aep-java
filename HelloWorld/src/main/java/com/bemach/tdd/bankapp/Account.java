package com.bemach.tdd.bankapp;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Account {
    private String mFirstName;
    private String mLastName;
    private String mAccountNumber;
    private BigDecimal mBalance = BigDecimal.ZERO;
    private EmailNotifier emailNotifier = new EmailNotifier();

    public EmailNotifier getEmailNotifier() {
        return emailNotifier;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public String getAccountNumber() {
        return mAccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.mAccountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return mBalance;
    }

    public void setBalance(BigDecimal balance) {
        this.mBalance = balance;
    }

    public boolean setupAccount() {
        mAccountNumber = "0000234002340566"; //TODO: hardcoded account number for now
        mBalance = BigDecimal.ZERO;
        return true;
    }

    public void deposit(BigDecimal amount) {

        if(amount.floatValue() < 0) {
            throw new IllegalArgumentException("Deposit amount invalid");
        }
        BigDecimal newBalance = getBalance().add(amount);
        setBalance(newBalance);
    }

    public void withdraw(BigDecimal amount) {


        BigDecimal newBalance = getBalance().subtract(amount);
        if (newBalance.doubleValue() < 0) {
            //getEmailNotifier().sendMessage("service@bank.com", "joe@somewhere.com", "Insufficient funds", "blah blah blah");
        } else {
            setBalance(newBalance);
        }
    }
}
