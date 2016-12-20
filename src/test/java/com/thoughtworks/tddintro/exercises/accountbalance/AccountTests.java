package com.thoughtworks.tddintro.exercises.accountbalance;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        Account account = new Account();
        account.setBalance(100);
        Integer initialBalance = account.getBalance();

        account.deposit(50);
        Integer result = account.getBalance();

        assertThat(result, is(150));
        assertTrue(result > initialBalance);
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        Account account = new Account();
        account.setBalance(100);
        Integer initialBalance = account.getBalance();

        account.withdraw(50);
        Integer result = account.getBalance();

        assertThat(result, is(50));
        assertTrue(result < initialBalance);
    }

    @Test
    @Ignore  // Remove each @Ignore and implement test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){

    }
}
