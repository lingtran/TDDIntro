package com.thoughtworks.tddintro.exercises.accountbalance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AccountTests {
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account();
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        account.setBalance(100);
        Integer initialBalance = account.getBalance();

        Integer result = account.deposit(50);

        assertThat(result, is(150));
        assertTrue(result > initialBalance);
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        account.setBalance(100);
        Integer initialBalance = account.getBalance();

        Integer result = account.withdraw(50);

        assertThat(result, is(50));
        assertTrue(result < initialBalance);
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        account.setBalance(50);
        Integer initialBalance = account.getBalance();

        Integer result = account.withdraw(100);

        assertThat(result, is(50));
        assertEquals(result, initialBalance);
    }
}
