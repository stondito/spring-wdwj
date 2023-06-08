package com.example.projectspring.services;

import com.example.projectspring.dto.SaleDto;
import com.example.projectspring.exceptions.CarException;
import com.example.projectspring.exceptions.SaleException;
import com.example.projectspring.models.Car;
import com.example.projectspring.models.Sale;
import com.example.projectspring.repos.SaleRepositoryI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SaleService {

    private final SaleRepositoryI saleRepository;
    private final CarService carService;
    private final ModelMapper mapper;

    public Long sellCar(Long carId, SaleDto saleDto) throws CarException {
        log.debug("Sell car");
        log.info("Sell car");
        log.error("Sell car");

        Car car = carService.get(carId);

        Sale sale = mapper.map(saleDto, Sale.class);
        sale.setCar(car);

        return saleRepository.save(sale).getId();
    }

    public Sale getSale(Long id) throws SaleException {
        return saleRepository
                .findById(id)
                .orElseThrow(() -> SaleException
                                    .builder()
                                    .timeErr(LocalDateTime.now())
                                    .httpStatus(HttpStatus.NOT_FOUND)
                                    .message("Sale not found with id: " +id)
                                    .build()
                );
    }

    public void deleteSell(Long id) throws SaleException {
        Sale sale = getSale(id);

        this.saleRepository.delete(sale);
    }

    public Long add(Sale sale) {
        return this.saleRepository.save(sale).getId();
    }

    public Long update(Sale sale) throws SaleException {
        Sale saleToUpdate = getSale(sale.getId());

        saleToUpdate.setInvoice(sale.getInvoice());
        saleToUpdate.setCar(sale.getCar());
        saleToUpdate.setSaleDate(sale.getSaleDate());
        saleToUpdate.setId(sale.getId());
        saleToUpdate.setTotalPrice(sale.getTotalPrice());

        return this.saleRepository.save(saleToUpdate).getId();
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

}
