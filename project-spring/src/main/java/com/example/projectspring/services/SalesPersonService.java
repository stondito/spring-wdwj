package com.example.projectspring.services;

import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.exceptions.SalesPersonException;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.SalesPerson;
import com.example.projectspring.repos.SalesPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SalesPersonService {

    private final SalesPersonRepository salesPersonRepository;
    private final DealershipService dealershipService;

    public Long add(SalesPerson salesPerson) {

        return salesPersonRepository.save(salesPerson).getId();
    }

    public SalesPerson get(Long id) throws SalesPersonException {

        return this.salesPersonRepository
                .findById(id)
                .orElseThrow(() -> SalesPersonException
                                    .builder()
                                    .timeErr(LocalDateTime.now())
                                    .message("SalesPerson not found with id:" + id)
                                    .httpStatus(HttpStatus.NOT_FOUND)
                                    .build()
                );
    }

    public void delete(Long id) throws SalesPersonException {
        SalesPerson salesPerson = get(id);

        this.salesPersonRepository.delete(salesPerson);
    }

    public Long update(SalesPerson salesPerson) throws SalesPersonException {
        SalesPerson salesPersonToUpdate = get(salesPerson.getId());

        salesPerson.setDealership(salesPerson.getDealership());
        salesPerson.setEmail(salesPerson.getEmail());
        salesPerson.setId(salesPerson.getId());
        salesPerson.setName(salesPerson.getName());
        salesPerson.setPhoneNumber(salesPerson.getPhoneNumber());

        return this.salesPersonRepository.save(salesPersonToUpdate).getId();
    }
}
