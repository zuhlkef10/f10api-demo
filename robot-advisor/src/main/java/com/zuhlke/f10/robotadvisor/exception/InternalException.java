package com.zuhlke.f10.robotadvisor.exception;

import com.zuhlke.f10.robotadvisor.config.RaErrorConfigEnum;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class InternalException extends RuntimeException {

    private String code;

    private String message;

    private String trackingId;

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public InternalException(RaErrorConfigEnum errorConfigEnum) {
        super(errorConfigEnum.getMessage());
        this.code = errorConfigEnum.getCode();
        this.message = errorConfigEnum.getMessage();
    }


    public InternalException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.trackingId = UUID.randomUUID().toString();
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
