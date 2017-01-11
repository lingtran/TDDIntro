package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if(amount < this.balance) {
            this.balance -= amount;
        }
    }
}
