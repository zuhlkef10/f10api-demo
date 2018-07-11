package com.zuhlke.f10.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
public class UnknownErrorException extends RuntimeException{

    public UnknownErrorException(){
        super("OBP-50000: Unknown Error.");
    }
}
