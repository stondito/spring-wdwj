package com.example.projectspring.services;

import com.example.projectspring.exceptions.SaleException;
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

    private final SaleRepositoryI saleRepository;

    public List<Car> getSalesByMake(String make) {
        return this.saleRepository.findCarByMake(make);
    }

    public Long sellCar(Car car, Invoice invoice) {
        Sale sale = new Sale();
        sale.setCar(car);
        sale.setInvoice(invoice);

        return this.saleRepository.save(sale).getId();
    }

    public Sale getSale(Long id) throws SaleException {
        return saleRepository
                .findById(id)
                .orElseThrow(() -> new SaleException("sale not found"));
    }

    public void deleteSell(Long id) throws SaleException {
        Sale sale = saleRepository
                .findById(id)
                .orElseThrow(() -> new SaleException("sale not found"));

        this.saleRepository.delete(sale);
    }

    public Long add(Sale sale) {
        return this.saleRepository.save(sale).getId();
    }

    public Long update(Sale sale) throws SaleException {
        Sale saleToUpdate = this.saleRepository
                .findById(sale.getId())
                .orElseThrow(() -> new SaleException("Sale not found"));

        saleToUpdate.setInvoice(sale.getInvoice());
        saleToUpdate.setCar(sale.getCar());
        saleToUpdate.setSaleDate(sale.getSaleDate());
        saleToUpdate.setId(sale.getId());
        saleToUpdate.setTotalPrice(sale.getTotalPrice());

        return this.saleRepository.save(saleToUpdate).getId();
    }

}
