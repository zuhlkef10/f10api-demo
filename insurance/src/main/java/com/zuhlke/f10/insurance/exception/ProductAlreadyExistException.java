package com.zuhlke.f10.insurance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) // 409
public class ProductAlreadyExistException extends RuntimeException {

    private String code;

    private String message;

    private HttpStatus httpStatus;

    public ProductAlreadyExistException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = HttpStatus.NOT_FOUND;
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
