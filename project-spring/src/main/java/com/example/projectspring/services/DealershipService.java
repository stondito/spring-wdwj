package com.example.projectspring.services;

import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.repos.DealershipRepositoryI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class DealershipService {

    private final CarService carService;
    private final InvoiceService invoiceService;
    private final DealershipRepositoryI dealershipRepository;
    private final SaleService saleService;

    public Long addCar(Car car) throws DealershipExceptions {

        log.debug("Adding car");
        log.info("Adding car");
        log.error("Adding car");

        if (car == null) {
            throw new DealershipExceptions("Car car is null");
        }

        // todo dealership id
        return carService.addCar(car, 1L);
    }

    public void removeCar(Long id) throws CarException {
        log.debug("Remove car");
        log.info("Remove car");
        log.error("Remove car");


        carService.removeCar(id);
    }

    public List<Car> searchCars(String make, String model, int year, BigDecimal price) throws CarException {
        log.debug("Search car");
        log.info("Search car");
        log.error("Search car");

        return carService.searchCars(make, model, year, price);
    }

    public void sellCar(Long carId, String customerName, BigDecimal price) throws CarException {
        log.debug("Sell car");
        log.info("Sell car");
        log.error("Sell car");


        Invoice invoice = invoiceService.getInvoiceByName(customerName);

        if (invoice == null) {
            invoice = new Invoice();
            invoice.setCustomerName(customerName);
            invoice.setSalesPrice(price);
            invoice.setPurchaseDate(LocalDate.now());
        }

        invoiceService.addInvoice(invoice);

        carService.removeCar(carId);
    }


    public Map<String, Integer> getSalesByMake(String make) {
        log.debug("Sales by make");
        log.info("Sales by make");
        log.error("Sales by make");

        List<Invoice> invoices = invoiceService.getInvoiceHistory();
        Map<String, Integer> salesByMake = new HashMap<>();

        int salesCount = saleService.getSalesByMake(make).size();

        salesByMake.put(make, salesCount);

        return salesByMake;
    }

    public double getTotalRevenue() {
        log.debug("Get Revenue");
        log.info("Get Revenue");
        log.error("Get Revenue");

        List<Invoice> invoices = invoiceService.getInvoiceHistory();

        return invoices.stream()
                .mapToDouble(a -> a.getSalesPrice().doubleValue())
                .sum();
    }

    public Long add(Dealership dealership) {
        log.debug("Add dealership");
        log.info("Add dealership");
        log.error("Add dealership");

        Dealership dealership1 = this.dealershipRepository.save(dealership);

        return dealership1.getId();
    }

    public void remove(Long id) throws DealershipExceptions {
        log.debug("Remove  dealership");
        log.info("Remove  dealership");
        log.error("Remove  dealership");

        Dealership dealership = getDealership(id);

        this.dealershipRepository.delete(dealership);
    }

    Dealership getDealership(Long id) throws DealershipExceptions {
        return this.dealershipRepository
                .findById(id)
                .orElseThrow(() -> new DealershipExceptions("Dealership not found"));
    }

    public Long update(Dealership dealership) throws DealershipExceptions {
        Dealership dealershipToUpdate = getDealership(dealership.getId());

        dealershipToUpdate.setAddress(dealership.getAddress());
        dealershipToUpdate.setEmail(dealership.getEmail());
        dealershipToUpdate.setId(dealership.getId());
        dealershipToUpdate.setName(dealership.getName());
        dealershipToUpdate.setCar(dealership.getCar());
        dealershipToUpdate.setSalesPersonList(dealership.getSalesPersonList());

        return this.dealershipRepository.save(dealershipToUpdate).getId();
    }

}
