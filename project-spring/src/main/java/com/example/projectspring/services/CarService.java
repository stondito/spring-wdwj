package com.example.projectspring.services;

import com.example.projectspring.config.AppConfig;
import com.example.projectspring.config.ModelMapperConfig;
import com.example.projectspring.dto.CarDto;
import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.repos.CarRepositoryI;
import com.example.projectspring.services.loggers.Logger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CarService {

    private final CarRepositoryI carRepository;
    private final ModelMapper mapper;

    public Long addCarDto(CarDto carDto) {
        log.debug("Adding car");
        log.info("Adding car");
        log.error("Adding car");

        Car car = mapper.map(carDto, Car.class);
        Car car1 = carRepository.save(car);

        return car1.getId();
    }

    public void removeCar(Long id) throws CarException {
        log.debug("Remove car");
        log.info("Remove car");
        log.error("Remove car");

        Car car = get(id);
        carRepository.delete(car);
    }

    public List<Car> searchCars(String make, String model, int year, BigDecimal price) throws CarException {
        log.debug("Search cars");
        log.info("Search cars");
        log.error("Search cars");

        List<Car> carList = carRepository.findCarByMakeAndModelAndYearAndPrice(make, model, year, price);

        if (carList == null || carList.isEmpty()) {
            throw CarException
                    .builder()
                    .timeErr(LocalDateTime.now())
                    .message("No cars found with given parameters")
                    .httpStatus(HttpStatus.NOT_FOUND)// No Content ?
                    .build();
        }

        return carList;
    }

    public List<Car> getAllCars() {
        log.debug("Get all cars");
        log.info("Get all cars");
        log.error("Get all cars");

        return carRepository.findAll();
    }


    public Long update(Car car) throws CarException {
        Car carToUpdate = get(car.getId());

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

    public Car get(Long id) throws CarException {
        return this.carRepository
                .findById(id)
                .orElseThrow(() -> CarException
                                    .builder()
                                    .timeErr(LocalDateTime.now())
                                    .message("Car not found with id:" + id)
                                    .httpStatus(HttpStatus.NOT_FOUND)
                                    .build()
                );
    }

}
