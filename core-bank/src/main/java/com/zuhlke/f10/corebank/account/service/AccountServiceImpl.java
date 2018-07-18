package com.zuhlke.f10.corebank.account.service;

import com.zuhlke.f10.corebank.account.exception.ResourceNotFoundException;
import com.zuhlke.f10.corebank.account.exception.TransferException;
import com.zuhlke.f10.corebank.account.repository.AccountRepository;
import com.zuhlke.f10.corebank.account.repository.TransactionRepository;
import com.zuhlke.f10.corebank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        //TODO

        //2. check balance of source account
        AccountBalance balance = getAccountBalance(id);
        if (balance.getAmount().compareTo(detail.getAmount()) < 0){
            throw new TransferException("Insufficient Balance");
        }

        //3. create debit transaction on source account
        Transaction debitTran = new Transaction();
        //TODO

        //4. create credit transaction on destination account
        Transaction creditTran = new Transaction();
        //TODO


        TransferResponse response = new TransferResponse();
        //TODO

        return response;
    }

    @Override
    public AccountBalance getAccountBalance(String id) {

         Account account = getAccount(id);

        //compute balance from transaction repository
        AccountTransactions accountTransactions = getAccountTransactions(id);
        List<Transaction> transactions = accountTransactions.getData();

        //1. Get sum of all credit transactions
        BigDecimal sumCredit = transactions.stream()
                .filter(t -> t.getCreditDebitIndicator().equals(Transaction.CreditDebitIndicatorEnum.CREDIT) )
                .map(t -> t.getAmount())
                .reduce(BigDecimal::add).orElse(new BigDecimal(0));

        //2. Get sum of all debit transactions
        BigDecimal sumDebit = transactions.stream()
                .filter(t -> t.getCreditDebitIndicator().equals(Transaction.CreditDebitIndicatorEnum.DEBIT) )
                .map(t -> t.getAmount())
                .reduce(BigDecimal::add).orElse(new BigDecimal(0));

        //3. balance = sum of credit - sum of debit
        BigDecimal calculatedBalance = sumCredit.subtract(sumDebit);

        AccountBalance balance = new AccountBalance();
        balance.setAccountId(id);
        balance.setDateTime(OffsetDateTime.now());
        balance.setCurrency(account.getCurrency());
        balance.setAmount(calculatedBalance);

        return balance;
    }

    @Override
    public AccountTransactions getAccountTransactions(String id) {

        AccountTransactions transactions = new AccountTransactions();
        transactions.setData(transactionRepository.findAll());

        return transactions;
    }

    @Override
    public TransferResponse createTransaction(String id, Transaction transaction) {

        //throw exception if account does not exists
        getAccount(id);

        //transaction.setBookingDateTime(OffsetDateTime.now());
        //transaction.setValueDateTime(OffsetDateTime.now());
        transaction.setId(UUID.randomUUID().toString());
        transaction.setAccountId(id);
        Transaction savedTransaction = transactionRepository.save(transaction);


        TransferResponse response = new TransferResponse();
        response.setReferenceId(savedTransaction.getId());
        response.setStatus(TransferResponse.StatusEnum.ACCEPTED);

        return response;
    }
}
