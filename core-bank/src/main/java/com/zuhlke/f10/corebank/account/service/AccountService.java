package com.zuhlke.f10.corebank.account.service;

import com.zuhlke.f10.corebank.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    void deleteAccount(String id);

    Account getAccount(String id);

    Account updateAccount(String id, Account account);

    List<Account> listAccounts();

    TransferResponse makeFundTransfer(String id, FundTransferDetail detail);

    AccountBalance getAccountBalance(String id);

    AccountTransactions getAccountTransactions(String id);

    TransferResponse createTransaction(String id, Transaction transaction);


}
