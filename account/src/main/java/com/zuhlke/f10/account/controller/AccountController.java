package com.zuhlke.f10.account.controller;

import com.zuhlke.f10.account.model.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @RequestMapping(value="/accounts", method = RequestMethod.GET)
    public Account searchAccounts(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Account("1", "CURRENT", "1");
    }

}
