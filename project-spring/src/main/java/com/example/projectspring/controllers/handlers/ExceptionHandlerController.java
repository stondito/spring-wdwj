package com.example.projectspring.controllers.handlers;

import com.example.projectspring.exceptions.*;
import com.sun.jdi.InvocationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {DealershipExceptions.class})
    public ResponseEntity<Object> handleDealership(DealershipExceptions d, HttpServletRequest httpServletRequest) {
        d.setUri(httpServletRequest.getRequestURI());
        return new ResponseEntity<>(d, d.getHttpStatus());
    }

    @ExceptionHandler(value = {CarException.class})
    public ResponseEntity<Object> handleCar(CarException c, HttpServletRequest request) {
        c.setUri(request.getRequestURI());
        return new ResponseEntity<>(c, c.getHttpStatus());
    }

    @ExceptionHandler(value = {SaleException.class})
    public ResponseEntity<Object> handleSale(SaleException s, HttpServletRequest request) {
        s.setUri(request.getRequestURI());
        return new ResponseEntity<>(s, s.getHttpStatus());
    }

    @ExceptionHandler(value = {SalesPersonException.class})
    public ResponseEntity<Object> handleSalesPerson(SalesPersonException sp, HttpServletRequest request) {
        sp.setUri(request.getRequestURI());
        return new ResponseEntity<>(sp, sp.getHttpStatus());
    }

    @ExceptionHandler(value = {InvocationException.class})
    public ResponseEntity<Object> handleInvoice(InvoiceException i, HttpServletRequest request) {
        i.setUri(request.getRequestURI());
        return new ResponseEntity<>(i, i.getHttpStatus());
    }
}
