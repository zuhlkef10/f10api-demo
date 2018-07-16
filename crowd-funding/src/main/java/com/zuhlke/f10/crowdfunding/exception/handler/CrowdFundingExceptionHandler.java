package com.zuhlke.f10.crowdfunding.exception.handler;

import com.zuhlke.f10.crowdfunding.exception.InternalException;
import com.zuhlke.f10.crowdfunding.model.ServerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class CrowdFundingExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServerError> handleException(final Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ServerError()
                .code("CF-500")
                .message("Internal Error")
                .trackingId(UUID.randomUUID().toString()));
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<ServerError> handleException(final InternalException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new ServerError()
                .code(exception.getCode())
                .message(exception.getMessage())
                .trackingId(exception.getTrackingId()));
    }

}
