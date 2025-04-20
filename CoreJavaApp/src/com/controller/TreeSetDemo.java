package com.controller;

import com.model.Account;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet();
        set.add(5);
        set.add(1);
        set.add(1);
        set.add(9);

        System.out.println(set);

        Account account1 = new Account(123, "SAVINGS", 3600.0);
        Account account2 = new Account(342, "CURRENT", 12000.0);
        Account account3 = new Account(642, "SAVINGS", 32100.0);
        Set<Account> setAccount = new TreeSet<>();

        setAccount.add(account1);
        setAccount.add(account2);
        setAccount.add(account3);
        System.out.println(setAccount);

    }
}
