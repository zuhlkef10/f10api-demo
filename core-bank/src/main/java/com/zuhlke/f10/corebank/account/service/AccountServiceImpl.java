package com.zuhlke.f10.corebank.account.service;

import com.zuhlke.f10.corebank.account.exception.ResourceNotFoundException;
import com.zuhlke.f10.corebank.account.repository.AccountRepository;
import com.zuhlke.f10.corebank.account.repository.TransactionRepository;
import com.zuhlke.f10.corebank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

   @Autowired
   private AccountRepository accountRepository;

   @Autowired
   private TransactionRepository transactionRepository;

    public AccountServiceImpl() {
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccount(String id) {
        return accountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("404","Account not found"));
    }

    @Override
    public Account updateAccount(String id, Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public TransferResponse makeFundTransfer(String id, FundTransferDetail detail) {
        //1. check if destination account exist

        //2. check balance of source account

        //3. create debit transaction on source account

        //4. create credit transaction on destination account

        return null;
    }

    @Override
    public AccountBalance getAccountBalance(String id) {

         Account account = getAccount(id);

        //compute balance from transaction repository
        //1. Get sum of all credit transactions

        //2. Get sum of all debit transactions

        //3. balance = sum of credit - sum of debit


        AccountBalance balance = new AccountBalance();
        balance.setAccountId(id);
        balance.setDateTime(OffsetDateTime.now());
        balance.setCurrency(account.getCurrency());

        return balance;
    }

    @Override
    public AccountTransactions getAccountTransactions(String id) {

        AccountTransactions transactions = new AccountTransactions();
        transactions.setData(transactionRepository.findAll());

        return transactions;
    }
}
