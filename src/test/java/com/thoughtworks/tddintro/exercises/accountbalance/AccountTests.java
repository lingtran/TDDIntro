package com.thoughtworks.tddintro.exercises.accountbalance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private Account account;

    public void setUpInitialBalance(int amount) {
        account = new Account(amount);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        setUpInitialBalance(100);

        account.deposit(50);

        Integer result = account.getBalance();

        assertThat(result, is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        setUpInitialBalance(100);

        account.withdraw(50);

        Integer result = account.getBalance();

        assertThat(result, is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        setUpInitialBalance(50);

        account.withdraw(100);

        Integer result = account.getBalance();

        assertThat(result, is(50));
    }
}
