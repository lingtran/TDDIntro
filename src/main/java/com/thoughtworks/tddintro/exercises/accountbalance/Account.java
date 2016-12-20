package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }


}
