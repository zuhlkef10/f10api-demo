package com.zuhlke.f10.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // 404
public class AccountDoesNotExistException extends RuntimeException{
    public AccountDoesNotExistException(){
        super("OBP-30018: Bank Account not found. Please specify valid values for BANK_ID and ACCOUNT_ID.");
    }
}

