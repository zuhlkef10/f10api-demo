package com.zuhlke.f10.corebank.account.service;

import com.zuhlke.f10.corebank.account.exception.ResourceNotFoundException;
import com.zuhlke.f10.corebank.account.exception.TransferException;
import com.zuhlke.f10.corebank.account.repository.AccountRepository;
import com.zuhlke.f10.corebank.account.repository.TransactionRepository;
import com.zuhlke.f10.corebank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
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
    public Account getAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("404","Account not found"));
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {

        return accountRepository.findByAccountNumber(accountNumber)
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

        Account sourceAccount = getAccountById(id);

        //1. check if destination account exist
        Account destAccount = getAccountByNumber(detail.getCreditAccountNumber());

        //2. check balance of source account
        AccountBalance balance = getAccountBalance(id);
        if (balance.getBalance().compareTo(detail.getAmount()) < 0){
            throw new TransferException("Insufficient Balance");
        }

        //3. create debit transaction on source account
        Transaction debitTran = new Transaction();
        debitTran.setAccountId(sourceAccount.getId());
        debitTran.setAmount(detail.getAmount());
        debitTran.setCreditDebitIndicator(Transaction.CreditDebitIndicatorEnum.DEBIT);
        debitTran.setTransactionCode("Fund Transfer");
        debitTran.setTransactionReference(destAccount.getAccountNumber());

        Transaction savedDebitTran = transactionRepository.save(debitTran);

        //4. create credit transaction on destination account
        Transaction creditTran = new Transaction();
        creditTran.setAccountId(destAccount.getId());
        creditTran.setAmount(detail.getAmount());
        creditTran.setCreditDebitIndicator(Transaction.CreditDebitIndicatorEnum.CREDIT);
        creditTran.setTransactionCode("Fund Transfer");
        creditTran.setTransactionReference(sourceAccount.getAccountNumber());

        Transaction savedCreditTran = transactionRepository.save(creditTran);

        TransferResponse response = new TransferResponse();
        response.setStatus(TransferResponse.StatusEnum.ACCEPTED);
        response.setReferenceId(savedDebitTran.getId() + "-" +  savedCreditTran.getId());

        return response;
    }


    @Override
    public AccountBalance getAccountBalance(String id) {

         Account account = getAccountById(id);

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
        balance.setCurrency(account.getCurrency());
        balance.setBalance(calculatedBalance);
        balance.setAccountNumber(account.getAccountNumber());
        balance.setId(account.getId());
        balance.setBankCode(account.getBankCode());
        balance.setName(account.getName());
        balance.setProductType(account.getProductType());

        return balance;
    }

    @Override
    public AccountTransactions getAccountTransactions(String id) {

        AccountTransactions transactions = new AccountTransactions();
        transactions.setData(transactionRepository.findByAccountId(id));

        return transactions;
    }

    @Override
    public TransferResponse createTransaction(String id, Transaction transaction) {

        //throw exception if account does not exists
        getAccountById(id);

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
