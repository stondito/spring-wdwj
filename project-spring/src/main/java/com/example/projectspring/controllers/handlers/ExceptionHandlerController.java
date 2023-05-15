package com.example.projectspring.controllers.handlers;

import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.exceptions.SaleException;
import com.example.projectspring.exceptions.SalesPersonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {DealershipExceptions.class})
    public ResponseEntity<Object> handleDealership(DealershipExceptions d) {
        // todo class to use instead d.getMessage()
        return new ResponseEntity<>(d.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CarException.class})
    public ResponseEntity<Object> handleCar(CarException c) {
        return new ResponseEntity<>(c.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {SaleException.class})
    public ResponseEntity<Object> handleSale(SaleException s) {
        return new ResponseEntity<>(s.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {SalesPersonException.class})
    public ResponseEntity<Object> handleSalesPerson(SalesPersonException sp) {
        return new  ResponseEntity<>(sp.getMessage(), HttpStatus.NOT_FOUND);
    }
}
