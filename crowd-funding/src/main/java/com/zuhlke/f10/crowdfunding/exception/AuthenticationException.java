package com.zuhlke.f10.crowdfunding.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends RuntimeException {

    private String code;

    private String message;

    private HttpStatus httpStatus;

    public AuthenticationException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = HttpStatus.UNAUTHORIZED;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
