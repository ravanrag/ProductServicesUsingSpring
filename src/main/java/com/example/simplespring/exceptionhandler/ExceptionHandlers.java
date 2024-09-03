package com.example.simplespring.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.UnknownHostException;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Void> handleArithmeticException(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnknownHostException.class)
    public  ResponseEntity<String> hostnotfound(){
        return new ResponseEntity<>(new String("backend Unreachable"),HttpStatus.BAD_GATEWAY);
    }
}
