package com.aaurzola.bankExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFountException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFountException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }

}
