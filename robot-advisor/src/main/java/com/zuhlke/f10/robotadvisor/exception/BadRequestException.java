package com.zuhlke.f10.robotadvisor.exception;

import com.zuhlke.f10.robotadvisor.config.RaErrorConfigEnum;
import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {

    private String code;

    private String message;

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BadRequestException(RaErrorConfigEnum errorConfigEnum) {
        super(errorConfigEnum.getMessage());
        this.code = errorConfigEnum.getCode();
        this.message = errorConfigEnum.getMessage();
    }

    public BadRequestException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
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
