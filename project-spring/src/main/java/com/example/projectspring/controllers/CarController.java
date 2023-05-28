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
@RequestMapping(path = "/car")
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    @PostMapping(path = "/add")
    public ResponseEntity<Long> add(@Validated @RequestBody CarDto carDto) throws DealershipExceptions {

        return ResponseEntity.ok(this.carService.addCarDto(carDto));
    }

    @DeleteMapping(path = "/delete")
    public void remove(@RequestParam(name = "id", required = true) Long id) throws CarException {
        this.carService.removeCar(id);
    }


    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity
                .ok(this.carService.getAllCars());
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Long> update(@RequestBody Car car) throws CarException {
        return ResponseEntity.ok(this.carService.update(car));
    }
}
