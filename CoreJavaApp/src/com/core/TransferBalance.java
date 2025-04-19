package com.core;

import com.model.Account;

public abstract class TransferBalance {
     public abstract boolean validateBalance(Account account);
     public abstract boolean validateInfo(Account account);
     public abstract boolean validateTransferAmount(Account account, double amount);
     public abstract void transferAmount(Account sender, Account receiver,double amount);
}
