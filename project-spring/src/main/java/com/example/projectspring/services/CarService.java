package com.example.projectspring.services;

import com.example.projectspring.config.AppConfig;
import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.repos.CarRepositoryI;
import com.example.projectspring.services.loggers.Logger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CarService {

    private final CarRepositoryI carRepository;
    private final SaleService saleService;
    private final InvoiceService invoiceService;
    private final DealershipService dealershipService;

    public Long addCar(Car car, Long dealershipId) throws DealershipExceptions {
        log.debug("Adding car");
        log.info("Adding car");
        log.error("Adding car");

        Dealership dealership = dealershipService.getDealership(dealershipId);

        // if car already exists
        car.setCarDealership(dealership);
        Car car1 = carRepository.save(car);

        return car1.getId();
    }

    public void removeCar(Long id) throws CarException {
        log.debug("Remove car");
        log.info("Remove car");
        log.error("Remove car");

        Car car = carRepository.
                    findById(id).
                    orElseThrow(() -> new CarException("No such car"));

        carRepository.delete(car);
    }

    public List<Car> searchCars(String make, String model, int year, BigDecimal price) throws CarException {
        log.debug("Search cars");
        log.info("Search cars");
        log.error("Search cars");

        List<Car> carList = carRepository.findCarByMakeAndModelAndYearAndPrice(make, model, year, price);

        if (carList == null || carList.isEmpty()) {
            throw new CarException("No found cars");
        }

        return carList;
    }

    public List<Car> getAllCars() {
        log.debug("Get all cars");
        log.info("Get all cars");
        log.error("Get all cars");

        return carRepository.findAll();
    }

    public Long sellCar(Long id, String customerName) throws CarException {
        log.debug("Sell car");
        log.info("Sell car");
        log.error("Sell car");

        Car car = this.carRepository.findById(id).
                orElseThrow(() -> new CarException("no such car"));

        Invoice invoice = invoiceService.getInvoiceByName(customerName);

        return this.saleService.sellCar(car, invoice);
    }

    public Long update(Car car) throws CarException {
        Car carToUpdate = this.carRepository
                            .findById(car.getId())
                            .orElseThrow(() -> new CarException("Car not found"));

        carToUpdate.setModel(car.getModel());
        carToUpdate.setCarDealership(car.getCarDealership());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setId(car.getId());
        carToUpdate.setMake(car.getMake());
        carToUpdate.setPrice(car.getPrice());
        carToUpdate.setYear(car.getYear());

        return this.carRepository.save(carToUpdate).getId();
    }

}
