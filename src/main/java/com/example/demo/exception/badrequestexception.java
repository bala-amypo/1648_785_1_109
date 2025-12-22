package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class badrequestexception extends RuntimeException {
    public badrequestexception(String message) {
        super(message);
    }
}
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import com.example.demo.exception.validationexce;

@RestControllerAdvice
public class golbalexce{
    @ExceptionHandler(validationexce.class)
    public ResponseEntity<String> handleValidationexeception(validationexce ex){
    return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
    }
}
