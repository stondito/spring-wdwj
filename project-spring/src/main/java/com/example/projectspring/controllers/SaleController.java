package com.example.projectspring.controllers;

import com.example.projectspring.exceptions.SaleException;
import com.example.projectspring.models.Sale;
import com.example.projectspring.services.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sale")
@AllArgsConstructor
public class SaleController {

    private final SaleService service;

    @GetMapping(path = "/get")
    public Sale getSale(@RequestParam(name = "id", required = true) Long id) throws SaleException {
        return service.getSale(id);
    }

    @DeleteMapping(path = "/delete")
    public void deleteSale(@RequestParam(name = "id", required = true) Long id) throws SaleException {
        service.deleteSell(id);
    }

    @PostMapping(path = "/add")
    public Long addSale(@RequestBody Sale sale) {
        return service.add(sale);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Long> update(@RequestBody Sale sale) throws SaleException {
        return ResponseEntity.ok(this.service.update(sale));
    }
}
