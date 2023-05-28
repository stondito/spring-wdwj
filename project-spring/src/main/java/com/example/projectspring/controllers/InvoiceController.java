package com.example.projectspring.controllers;

import com.example.projectspring.exceptions.InvoiceException;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/invoice")
@AllArgsConstructor
public class InvoiceController {

    private final InvoiceService service;

    @PostMapping(path = "/add")
    public ResponseEntity<Long> addInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity
                .ok(this.service.addInvoice(invoice));
    }

    @GetMapping(path = "/history")
    public ResponseEntity<List<Invoice>> getInvoiceHistory() {

        return ResponseEntity.ok(this.service.getInvoiceHistory());
    }

    @GetMapping(path = "/totalPrice")
    public ResponseEntity<BigDecimal> calculateTotalPrice(@RequestBody Invoice invoice) {

        return ResponseEntity.ok(this.service.calculateTotalPrice(invoice));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Long> update(@RequestBody Invoice invoice) throws InvoiceException {
        return ResponseEntity.ok(this.service.update(invoice));
    }

//    @DeleteMapping(path = "/invoice")
//    public ResponseEntity<Long> deleteInvoice(@RequestParam(name = "id", required = true) Long id) {
//        //return service.
//    }


}
