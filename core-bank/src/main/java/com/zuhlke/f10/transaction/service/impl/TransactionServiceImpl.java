package com.zuhlke.f10.transaction.service.impl;

import com.zuhlke.f10.account.exception.AccountDoesNotExistException;
import com.zuhlke.f10.account.exception.TransferException;
import com.zuhlke.f10.account.model.Account;
import com.zuhlke.f10.account.repository.AccountRepository;
import com.zuhlke.f10.account.service.AccountService;
import com.zuhlke.f10.transaction.model.Transaction;
import com.zuhlke.f10.transaction.model.TransactionRequest;
import com.zuhlke.f10.transaction.model.TransactionResponse;
import com.zuhlke.f10.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!mock")
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Transaction getTransactionById(String bankId, String accountId,  String transactionId) {
        return new Transaction();
    }

    @Override
    public TransactionResponse createTransactionRequest(String bankId, String accountId,  TransactionRequest transactionRequest) {

        Account sourceAcct = new Account();
        sourceAcct.setBankId(bankId);
        sourceAcct.setId(accountId);



        return new TransactionResponse();
    }


    private void transferFund(Account source, Account dest, double amount, String currency) {

        //1. check if both accounts exist
        Account sourceAccount = accountRepository.findByBankIdAndAccountId(source.getBankId(),source.getId())
                .orElseThrow( () -> new AccountDoesNotExistException());

        Account destAccount = accountRepository.findByBankIdAndAccountId(dest.getBankId(),dest.getId())
                .orElseThrow( () -> new AccountDoesNotExistException());

        //2. check if source account has sufficient balance
        if (sourceAccount.getBalance().getAmount() < amount){
            throw new TransferException("Insufficient amount");
        }

        //3. make the transfer
        sourceAccount.getBalance().setAmount(sourceAccount.getBalance().getAmount() - amount);
        destAccount.getBalance().setAmount(destAccount.getBalance().getAmount() + amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(destAccount);

    }
}
