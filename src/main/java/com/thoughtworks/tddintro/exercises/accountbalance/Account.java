package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public int deposit(int amount) {
        return this.balance += amount;
    }

    public int withdraw(int amount) {
        if(amount > this.balance) {
            return this.balance;
        } else {
            return this.balance -= amount;
        }
    }
}
