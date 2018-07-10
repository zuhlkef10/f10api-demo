package com.zuhlke.f10.bank.controller;

import com.zuhlke.f10.bank.model.Bank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @RequestMapping(value="/banks", method = RequestMethod.GET)
    public Bank searchBanks(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Bank("1", "Test Bank", "TB SIN");
    }

}
