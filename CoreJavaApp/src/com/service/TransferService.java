package com.service;

import com.core.TransferBalance;
import com.model.Account;
import com.repository.AccountRepository;

import java.util.List;

public class TransferService extends TransferBalance {

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

    public boolean transfer(int senderId, int receiverId, double amount) {
        boolean isSuccess = true;
        //fetching account object details based on id
        List<Account> list = accountRepository.getList();
        System.out.println(receiverId);

        Account senderAccount = null;
        for(Account a : list){
            if(a.getId() == senderId){
                senderAccount = a;
                isSuccess = true;
                break;
            }
            else{
                isSuccess= false;
            }
        }
        Account receiverAccount = null;
        for(Account a : list){
            if(a.getId() == receiverId){
                receiverAccount = a;
                isSuccess = true;
                break;
            }
            else{
                isSuccess= false;
            }
        }
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm        boolean status = validateBalance(senderAccount);
        if(status == false)
            isSuccess= false;

        status = validateInfo(senderAccount);
        if(status == false)
            isSuccess= false;

        status = validateInfo(receiverAccount);
        if(status == false)
            isSuccess= false;

        status = validateTransferAmount(senderAccount, amount);
        if(status == false)
            isSuccess= false;

        transferAmount(senderAccount, receiverAccount, amount);
        return isSuccessmmmmmmmmmmmmmmmmmmmmmmmm;
    }
}
