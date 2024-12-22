package com.example.simplespring.exceptionhandler;

import com.example.simplespring.Dtos.ProductNotFoundExceptionDTO;
import com.example.simplespring.Exceptions.ProductNotFoundException;
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
        return new ResponseEntity<>("Unreachable Backend",HttpStatus.BAD_GATEWAY);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(ProductNotFoundException e){
        ProductNotFoundExceptionDTO exceptionDTO = new ProductNotFoundExceptionDTO();
        exceptionDTO.setMessage("the product with Product id " + e.getProductId()+" is not found");
        exceptionDTO.setResolution("enter the correct product id");
        return new ResponseEntity<>(exceptionDTO,HttpStatus.BAD_REQUEST);
    }

}
