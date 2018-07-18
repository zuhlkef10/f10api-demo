package com.zuhlke.f10.crowdlending.exception.handler;

import com.zuhlke.f10.crowdlending.config.ClErrorConfigEnum;
import com.zuhlke.f10.crowdlending.exception.*;
import com.zuhlke.f10.crowdlending.model.GenericError;
import com.zuhlke.f10.crowdlending.model.ServerError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class CrowdLendingExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrowdLendingExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServerError> handleException(final Exception exception) {
        LOGGER.error("Internal Error Occurred ", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ServerError()
                .code(ClErrorConfigEnum.CL_INTERNAL_ERROR.getCode())
                .message(ClErrorConfigEnum.CL_INTERNAL_ERROR.getMessage())
                .trackingId(UUID.randomUUID().toString()));
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<ServerError> handleInternalException(final InternalException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new ServerError()
                .code(exception.getCode())
                .message(exception.getMessage())
                .trackingId(exception.getTrackingId()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericError> handleBadRequestException(final BadRequestException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new GenericError()
                .code(exception.getCode())
                .message(exception.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GenericError> handleResourceNotFoundException(final ResourceNotFoundException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new GenericError()
                .code(exception.getCode())
                .message(exception.getMessage()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<GenericError> handleAuthenticationException(final AuthenticationException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new GenericError()
                .code(exception.getCode())
                .message(exception.getMessage()));
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<GenericError> handleAuthorizationException(final AuthorizationException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new GenericError()
                .code(exception.getCode())
                .message(exception.getMessage()));
    }


}
