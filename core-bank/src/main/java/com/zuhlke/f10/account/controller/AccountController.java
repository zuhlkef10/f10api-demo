package com.zuhlke.f10.account.controller;

import com.zuhlke.f10.account.model.Account;
import com.zuhlke.f10.account.model.AccountCr;
import com.zuhlke.f10.account.exception.UnknownErrorException;
import com.zuhlke.f10.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/banks/{bankId}/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/{accountId}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("bankId") String bankId
                                  , @PathVariable("accountId") String accountId) {


        return accountService.getAccountByBankIdAndAccountId(bankId,accountId);
    }


    @RequestMapping(value="/{accountId}", method = RequestMethod.PUT)
    public AccountCr createAccount(@PathVariable("bankId") String bankId
            , @PathVariable("accountId") String accountId
            , AccountCr accountCr) {

           Account account = new Account();

           account.setBankId(bankId);
           account.setId(accountId);

           account.setNumber(accountCr.getNumber());
           account.setLabel(accountCr.getLabel());
           account.setBalance(accountCr.getBalance());

           ArrayList<Account.AccountRouting> accountRoutings  = new ArrayList<>();
           accountRoutings.add(accountCr.getAccountRouting());
           account.setAccountRoutings(accountRoutings);

           ArrayList<Account.AccountRule> accountRules = new ArrayList<>();
           accountRules.add(accountCr.getAccountRule());
           account.setAccountRules(accountRules);

           ArrayList<Account.Owner> owners = new ArrayList<>();
           owners.add(accountCr.getOwner());
           account.setOwners(owners);

           account.setType(accountCr.getType());

          Account savedAccount = accountService.create(account);
          if (savedAccount==null){
            throw new UnknownErrorException();
          }

        return accountCr;


    }




}
