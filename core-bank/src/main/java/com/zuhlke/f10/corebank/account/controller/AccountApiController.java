package com.zuhlke.f10.corebank.account.controller;

import com.zuhlke.f10.corebank.account.service.AccountService;
import com.zuhlke.f10.corebank.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountApiController implements AccountsApi{

    @Autowired
    private AccountService accountService;


    @Override
    @RequestMapping(value = "/accounts",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@Valid Account body) {

        return ResponseEntity.ok().body(accountService.createAccount(body));
    }

    @Override
    @RequestMapping(value = "/accounts/{id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") String id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @RequestMapping(value = "/accounts/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(accountService.getAccount(id));
    }


    @Override
    @RequestMapping(value = "/accounts/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("id") String id, @Valid Account body) {
        return ResponseEntity.ok().body(accountService.updateAccount(id,body));
    }



    @Override
    @RequestMapping(value = "/accounts",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<Account>> listAccounts() {
        return ResponseEntity.ok().body(accountService.listAccounts());
    }


     @Override
    @RequestMapping(value = "/accounts/{id}/transfer",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<TransferResponse> makeFundTransfer(@PathVariable("id") String id
                                           , @Valid FundTransferDetail body) {
         return ResponseEntity.ok().body(accountService.makeFundTransfer(id, body));
    }

    @Override
    @RequestMapping(value = "/accounts/{id}/balance",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<AccountBalance> getAccountBalance(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(accountService.getAccountBalance(id));
    }

    @Override
    @RequestMapping(value = "/accounts/{id}/transactions",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<AccountTransactions> getAccountTransactions(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(accountService.getAccountTransactions(id));
    }

}
