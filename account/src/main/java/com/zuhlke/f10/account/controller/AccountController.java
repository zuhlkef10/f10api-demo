package com.zuhlke.f10.account.controller;

import com.zuhlke.f10.account.exception.UnknownErrorException;
import com.zuhlke.f10.account.model.Account;
import com.zuhlke.f10.account.model.AccountRouting;
import com.zuhlke.f10.account.model.CrAccount;
import com.zuhlke.f10.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/banks")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/{bankId}/accounts/{accountId}/account", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("bankId") String bankId
                                  ,@PathVariable("accountId") String accountId) {

        return accountService.getAccountById(bankId,accountId);
    }


    @RequestMapping(value="/{bankId}/accounts/{accountId}", method = RequestMethod.PUT)
    public CrAccount createAccount(@PathVariable("bankId") String bankId
            , @PathVariable("accountId") String accountId
            , CrAccount crAccount) {

        Account account = new Account();
        ArrayList<AccountRouting> accountRoutings = new ArrayList<>();
        accountRoutings.add(crAccount.getAccountRouting());
        account.setAccountRoutings(accountRoutings);
        account.setBalance(crAccount.getBalance());
        account.setBankId(bankId);
        account.setId(UUID.randomUUID().toString());
        account.setLabel(crAccount.getLabel());

        Account savedAccount = accountService.create(account);
        if (savedAccount==null){
            throw new UnknownErrorException();
        }

        return crAccount;


    }



}
