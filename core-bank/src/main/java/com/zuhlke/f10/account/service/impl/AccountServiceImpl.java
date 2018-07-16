package com.zuhlke.f10.account.service.impl;

import com.zuhlke.f10.account.exception.AccountDoesNotExistException;
import com.zuhlke.f10.account.exception.TransferException;
import com.zuhlke.f10.account.model.Account;
import com.zuhlke.f10.account.repository.AccountRepository;
import com.zuhlke.f10.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("!mock")
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountByBankIdAndAccountId(String bankId, String accountId) {


        Account account = accountRepository.findByBankIdAndAccountId(bankId,accountId)
                .orElseThrow( () -> new AccountDoesNotExistException());


        return account;
    }

    @Override
    public Account create(Account account) {

        Account savedAccount = accountRepository.save(account);

        return savedAccount;
    }




}

