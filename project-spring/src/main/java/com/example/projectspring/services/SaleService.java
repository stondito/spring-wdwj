package com.example.projectspring.services;

import com.example.projectspring.models.Car;
import com.example.projectspring.models.Invoice;
import com.example.projectspring.models.Sale;
import com.example.projectspring.repos.SaleRepositoryI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepositoryI saleRepository;

    public List<Car> getSalesByMake(String make) {
        return this.saleRepository.findCarByMake(make);
    }

    public Long sellCar(Car car, Invoice invoice) {
        Sale sale = new Sale();
        sale.setCar(car);
        sale.setInvoice(invoice);

        return this.saleRepository.save(sale).getId();
    }

}
