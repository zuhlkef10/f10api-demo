package com.zuhlke.f10.account.service;

import com.zuhlke.f10.account.model.Account;


public interface AccountService {


      Account getAccountByBankIdAndAccountId(String bankId, String accountId);

      Account create(Account account);

}
