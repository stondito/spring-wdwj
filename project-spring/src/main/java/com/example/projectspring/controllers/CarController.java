package com.example.projectspring.controllers;

import com.example.projectspring.dto.CarDto;
import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.services.CarService;
import com.example.projectspring.services.DealershipService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    private final DealershipService dealershipService;
    @PostMapping(path = "/add/{dealershipId}")
    public ResponseEntity<Long> add(@Validated @RequestBody CarDto carDto, @PathVariable Long dealershipId) throws DealershipExceptions {
        Dealership dealership = dealershipService.getDealership(dealershipId);

        return ResponseEntity.ok(this.carService.addCar(carDto, dealership));
    }

    @DeleteMapping(path = "/car.delete/{id}")
    public void remove(@PathVariable Long id) throws CarException {
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
    @DeleteMapping(path = "/car.sellCar/{id}")
    public ResponseEntity<Long> sellCar(@PathVariable(name = "id") Long id,
                           @RequestBody String customerName) throws CarException {

        return ResponseEntity
                .ok(this.carService.sellCar(id, customerName));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Long> update(@RequestBody Car car) throws CarException {
        return ResponseEntity.ok(this.carService.update(car));
    }
}
