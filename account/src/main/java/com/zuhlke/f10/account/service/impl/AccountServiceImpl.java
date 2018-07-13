package com.zuhlke.f10.account.service.impl;

import com.zuhlke.f10.account.exception.AccountDoesNotExistException;
import com.zuhlke.f10.account.model.Account;
import com.zuhlke.f10.account.repository.AccountRepository;
import com.zuhlke.f10.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile("!mock")
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountByBankIdAndAccountId(String bankId, String accountId) {


        List<Account> accounts = accountRepository.findByBankIdAndAccountId(bankId,accountId);

        if (accounts==null || accounts.size()==0){
            throw new AccountDoesNotExistException();
        }

        return accounts.get(0);
    }

    @Override
    public Account create(Account account) {

        Account savedAccount = accountRepository.save(account);

        return savedAccount;
    }
}

