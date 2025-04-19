package com.core;

import com.model.Account;

public interface TransferBalance {
      boolean validateBalance(Account account);
      boolean validateInfo(Account account);
      boolean validateTransferAmount(Account account, double amount);
      void transferAmount(Account sender, Account receiver,double amount);
}
