package com.repository;

import com.model.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountRepository {

    List<Account> list = new ArrayList();

    {
        Account account1 = new Account(123, "SAVINGS", 3600.0);
        Account account2 = new Account(342, "CURRENT", 12000.0);
        Account account3 = new Account(642, "SAVINGS", 32100.0);
        Account account4 = new Account(743, "CURRENT", 67000.0);
        Account account5 = new Account(216, "DEMAT", 3300.0);
        list = mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
    }

    public List<Account> getList() {
        return list;
    }
}
