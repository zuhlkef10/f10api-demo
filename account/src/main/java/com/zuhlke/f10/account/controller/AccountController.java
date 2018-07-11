package com.zuhlke.f10.account.controller;

import com.zuhlke.f10.account.model.Account;
import com.zuhlke.f10.account.model.CrAccount;
import com.zuhlke.f10.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


        return accountService.create(crAccount);
    }



}
