package com.db.carshop.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptions {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(exception.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }
}
