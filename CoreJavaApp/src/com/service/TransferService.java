package com.service;

import com.core.TransferBalance;
import com.exception.TransferException;
import com.model.Account;
import com.repository.AccountRepository;

import java.util.List;

public class TransferService implements TransferBalance {

    AccountRepository accountRepository = new AccountRepository();

    @Override
    public boolean validateBalance(Account account) {
        if (account.getBalance() > 0)
            return true;
        return false;
    }

    @Override
    public boolean validateInfo(Account account) {
        if (account.getType().equals("SAVINGS") || account.getType().equals("CURRENT"))
            return true;
        return false;
    }

    @Override
    public boolean validateTransferAmount(Account account, double amount) {
        if (account.getBalance() > amount)
            return true;
        return false;
    }

    @Override
    public void transferAmount(Account sender, Account receiver, double amount) {
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
    }

    public void transfer(int senderId, int receiverId, double amount) throws TransferException {

        //fetching account object details based on id
        List<Account> list = accountRepository.getList();

        Account senderAccount = null;
        for (Account a : list) {
            if (a.getId() == senderId) {
                senderAccount = a;
                break;
            }
        }
        //if senderaccount is still null after going thru this entire for loop then ID is invalid
        if (senderAccount == null)
            throw new TransferException("SenderAccount id not valid");
        Account receiverAccount = null;
        for (Account a : list) {
            if (a.getId() == receiverId) {
                receiverAccount = a;
                break;
            }
        }
        //if receiveraccount is still null after going thru this entire for loop then ID is invalid
        if (receiverAccount == null)
            throw new TransferException("ReceiverAccount id not valid");
       //after validatebalance check is still false, i will throw exception
        if (validateBalance(senderAccount) == false) {
            throw new TransferException("Sender account balance is low");
        }
        //after validateinfo check of sender is still false, i will throw exception
        if (validateInfo(senderAccount) == false) {
            throw new TransferException("Sender account is neither SAVINGS nor CURRENT");
        }
        //after validateinfo check of receriver is still false, i will throw exception
        if (validateInfo(receiverAccount) == false) {
            throw new TransferException("receiver account neither SAVINGS nor CURRENT");
        }
        //after validatetransferamount check is still false, i will throw exception
        if (validateTransferAmount(senderAccount, amount) == false) {
            throw new TransferException("Transfer amount is greater than the sender balance");
        }
        transferAmount(senderAccount, receiverAccount, amount);
    }
}
