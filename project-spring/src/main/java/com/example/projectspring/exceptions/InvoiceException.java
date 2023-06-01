package com.example.projectspring.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class InvoiceException extends RuntimeException {

    private HttpStatus httpStatus;
    private LocalDateTime timeErr;
    private String message;
    private String uri;
    public InvoiceException() {
        super();
    }

}
