package com.example.projectspring.services;

import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.exceptions.SalesPersonException;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.SalesPerson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceManager {
    private final DealershipService dealershipService;
    private final CarService carService;
    private final SalesPersonService salesPersonService;

    public void addCarInDealership(Long carId, Long dealershipId) throws CarException, DealershipExceptions {
        Car car = carService.get(carId);

        Dealership dealership = dealershipService.getDealership(dealershipId);

        dealership.getCar().add(car);

        dealershipService.update(dealership);
    }

    public void addDealershipInCar(Long carId, Long dealershipId) throws CarException, DealershipExceptions {
        Dealership dealership = dealershipService.getDealership(dealershipId);

        Car car = carService.get(carId);

        car.setCarDealership(dealership);

        carService.update(car);
    }

    public void addSalesPersonInDealership(Long salesPersonId, Long dealershipId) throws DealershipExceptions, SalesPersonException {
        SalesPerson salesPerson = salesPersonService.get(salesPersonId);

        Dealership dealership = dealershipService.getDealership(dealershipId);

        dealership.getSalesPersonList().add(salesPerson);

        dealershipService.update(dealership);
    }

    public void addDealershipInSalesPerson(Long salesPersonId, Long dealershipId) throws DealershipExceptions, SalesPersonException {
        SalesPerson salesPerson = salesPersonService.get(salesPersonId);

        Dealership dealership = dealershipService.getDealership(dealershipId);

        salesPerson.setDealership(dealership);

        salesPersonService.update(salesPerson);
    }


}
