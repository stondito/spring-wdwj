package com.example.projectspring.controllers;

import com.example.projectspring.dto.CarDto;
import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.exceptions.SalesPersonException;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.models.SalesPerson;
import com.example.projectspring.services.CarService;
import com.example.projectspring.services.DealershipService;
import com.example.projectspring.services.SalesPersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/dealerships")
@AllArgsConstructor
public class DealershipController {

    private final DealershipService service;

    @GetMapping(path = "/get")
    public ResponseEntity<Dealership> getDealership(@RequestParam(name = "id", required = true) Long id) throws DealershipExceptions {
        return ResponseEntity.ok(service.getDealership(id));
    }

//    @GetMapping(path = "/sales/{make}")
//    public ResponseEntity<Map<String, Integer>> getSalesByMake(@PathVariable(name = "make") String make) {
//
//        return ResponseEntity.ok(this.service.getSalesByMake(make));
//    }
//
//    @GetMapping(path = "/totalRevenue")
//    public ResponseEntity<Double> getTotalRevenue() {
//
//        return ResponseEntity.ok(this.service.getTotalRevenue());
//    }


    @PostMapping(path = "/add")
    public ResponseEntity<Long> add(@Validated @RequestBody Dealership dealership) {
        return ResponseEntity
                .ok(this.service.add(dealership));
    }

    @DeleteMapping(path = "/remove")
    public void remove(@RequestParam(name = "id", required = true) Long id) throws DealershipExceptions {
        this.service.remove(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Long> update(@RequestBody Dealership dealership) throws DealershipExceptions {
        return ResponseEntity.ok(this.service.update(dealership));
    }

}
