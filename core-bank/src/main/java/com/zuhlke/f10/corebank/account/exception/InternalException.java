package com.zuhlke.f10.corebank.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
public class InternalException extends RuntimeException {

    private String code;

    private String message;

    private String trackingId;

    private HttpStatus httpStatus;

    public InternalException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.trackingId = UUID.randomUUID().toString();
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
