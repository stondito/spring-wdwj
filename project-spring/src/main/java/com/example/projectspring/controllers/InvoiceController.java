package com.example.projectspring.controllers;

import com.example.projectspring.models.Invoice;
import com.example.projectspring.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService service;
    @Autowired
    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping(path = "invoice.add") // може да се върне обекта или само ID
    public ResponseEntity<Long> addInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity
                .ok(this.service.addInvoice(invoice));
    }

    @GetMapping(path = "invoice.history")
    public ResponseEntity<List<Invoice>> getInvoiceHistory() {

        return ResponseEntity.ok(this.service.getInvoiceHistory());
    }

    @GetMapping(path = "invoice.totalPrice")
    public ResponseEntity<BigDecimal> calculateTotalPrice(@RequestBody Invoice invoice) {

        return ResponseEntity.ok(this.service.calculateTotalPrice(invoice));
    }

}
