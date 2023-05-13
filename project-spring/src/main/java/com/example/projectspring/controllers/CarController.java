package com.example.projectspring.controllers;

import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Long> add(@Validated @RequestBody Car car) {

        return ResponseEntity.ok(this.carService.addCar(car));
    }

    @DeleteMapping(path = "/car.delete/{id}")
    public void remove(@RequestParam Long id) throws CarException {
        this.carService.removeCar(id);
    }

    @PostMapping(path = "/car.searchCars")
    public ResponseEntity<List<Car>> searchCars(@RequestParam(name = "make") String make,
                           @RequestParam(name = "model") String model,
                           @RequestParam(name = "year") int year,
                           @RequestParam(name = "price") BigDecimal price
    ) throws CarException {
        // todo map cars -> list ids
        return ResponseEntity
                .ok(this.carService.searchCars(make, model, year, price));
    }

    // todo mapper
    @GetMapping(path = "/car.getAll")
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity
                .ok(this.carService.getAllCars());
    }

    // todo mapper
    @DeleteMapping(path = "car.sellCar/{id}")
    public ResponseEntity<Long> sellCar(@RequestParam(name = "id") Long id,
                           @RequestBody String customerName) throws CarException {

        return ResponseEntity
                .ok(this.carService.sellCar(id, customerName));
    }
}
