package com.example.projectspring.controllers;

import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.services.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/dealerships")
public class DealershipController {

    private final DealershipService service;

    @Autowired
    public DealershipController(DealershipService service) {
        this.service = service;
    }

    @PostMapping(path = "/addCar")
    public ResponseEntity<Long> addCar(@RequestBody Car car) throws DealershipExceptions {
        return ResponseEntity.ok(this.service.addCar(car));
    }

    @DeleteMapping(path = "/deleteCar/{id}")
    public void removeCar(@RequestParam(name = "id") Long carId) throws CarException {
        this.service.removeCar(carId);
    }

    @GetMapping(path = "/searchCars") // todo dtoInCar
    public ResponseEntity<List<Car>> searchCars(String make, String model, int year, BigDecimal price) throws  CarException {
        return ResponseEntity
                .ok(this.service.searchCars(make, model, year, price));
    }

    @DeleteMapping(path = "/sellCar/{id}/{customerName}/")
    public void sellCar(@RequestParam(name = "id") Long carId,
                        @RequestParam String customerName,
                        @RequestBody BigDecimal price) throws CarException {

        this.service.sellCar(carId, customerName, price);
    }


    @GetMapping(path = "/sales/{make}")
    public ResponseEntity<Map<String, Integer>> getSalesByMake(@RequestParam(name = "make") String make) {

        return ResponseEntity.ok(this.service.getSalesByMake(make));
    }

    @GetMapping(path = "/dealership.totalRevenue")
    public ResponseEntity<Double> getTotalRevenue() {

        return ResponseEntity.ok(this.service.getTotalRevenue());
    }


    @PostMapping(path = "/dealership.add")
    public ResponseEntity<Long> add(@Validated @RequestBody Dealership dealership) {
        return ResponseEntity
                .ok(this.service.add(dealership));
    }

    @DeleteMapping(path = "/dealership.remove/{id}")
    public void remove(@RequestParam Long id) throws DealershipExceptions {
        this.service.remove(id);
    }

}
