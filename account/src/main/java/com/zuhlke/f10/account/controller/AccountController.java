package com.zuhlke.f10.account.controller;

import com.zuhlke.f10.account.exception.UnknownErrorException;
import com.zuhlke.f10.account.model.*;
import com.zuhlke.f10.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public AccountCr createAccount(@PathVariable("bankId") String bankId
            , @PathVariable("accountId") String accountId
            , AccountCr accountCr) {

           Account account = new Account();

           account.setBankId(bankId);
           account.setId(accountId);

           account.setNumber(accountCr.getNumber());
           account.setLabel(accountCr.getLabel());
           account.setBalance(accountCr.getBalance());

           ArrayList<AccountRouting> accountRoutings  = new ArrayList<>();
           accountRoutings.add(accountCr.getAccountRouting());
           account.setAccountRoutings(accountRoutings);

           ArrayList<AccountRule> accountRules = new ArrayList<>();
           accountRules.add(accountCr.getAccountRule());
           account.setAccountRules(accountRules);

           ArrayList<Owner> owners = new ArrayList<>();
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
