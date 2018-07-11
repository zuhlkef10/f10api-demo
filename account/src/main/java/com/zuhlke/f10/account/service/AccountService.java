package com.zuhlke.f10.account.service;

import com.zuhlke.f10.account.model.Account;


public interface AccountService {


     public Account getAccountById(String bankId, String accountId);

     public Account create(Account account);
}
