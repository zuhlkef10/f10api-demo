package com.zuhlke.f10.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // 404
public class AccountDoesNotExistException extends RuntimeException{
    public AccountDoesNotExistException(){
        super("OBP-30003: Account not found. Please specify a valid value for ACCOUNT_ID.");
    }
}

