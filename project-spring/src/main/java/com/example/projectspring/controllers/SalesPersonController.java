package com.example.projectspring.controllers;

import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.exceptions.SalesPersonException;
import com.example.projectspring.models.SalesPerson;
import com.example.projectspring.services.SalesPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sales.person")
@AllArgsConstructor
public class SalesPersonController {

    private final SalesPersonService service;

    @PostMapping(path = "/add")
    public Long add(@RequestBody SalesPerson salesPerson) {
        return this.service.add(salesPerson);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<SalesPerson> get(@RequestParam(name = "id", required = true) Long id) throws SalesPersonException {
        return ResponseEntity.ok(this.service.get(id));
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam(name = "id", required = true) Long id) throws SalesPersonException {
        this.service.delete(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Long> update(@RequestBody SalesPerson salesPerson) throws SalesPersonException {
        return ResponseEntity.ok(this.service.update(salesPerson));
    }


}
