package com.zuhlke.f10.bank.controller;

import com.zuhlke.f10.bank.model.Bank;
import com.zuhlke.f10.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class BankController {

    @Autowired
    private BankRepository repository;

    @RequestMapping(value="/banks", method = RequestMethod.GET)
    public Bank searchBanks(@RequestParam(value = "name", defaultValue = "World") String name) {
        Bank bank =  new Bank(UUID.randomUUID().toString(), "Test Bank", "TB SIN");
        this.repository.save(bank);

        List<Bank> banks = this.repository.findAll();
        System.out.println(" banks collection size : " + banks.size());
        return bank;
    }

}
