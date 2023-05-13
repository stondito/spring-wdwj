package com.example.projectspring.controllers.handlers;

import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {DealershipExceptions.class})
    public ResponseEntity<Object> handleDealership(DealershipExceptions d) {
        // todo class to use instead d.getMessage()
        return new ResponseEntity<>(d.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {CarException.class})
    public ResponseEntity<Object> handleCar(CarException c) {
        return new ResponseEntity<>(c.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
