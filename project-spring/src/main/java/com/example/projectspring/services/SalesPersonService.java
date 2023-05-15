package com.example.projectspring.services;

import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.exceptions.SalesPersonException;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.SalesPerson;
import com.example.projectspring.repos.SalesPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SalesPersonService {

    private final SalesPersonRepository salesPersonRepository;
    private final DealershipService dealershipService;

    public Long add(SalesPerson salesPerson, Long id) throws DealershipExceptions {
        Dealership dealership = dealershipService.getDealership(id);

        salesPerson.setDealership(dealership);

        return salesPersonRepository.save(salesPerson).getId();
    }

    public SalesPerson get(Long id) throws SalesPersonException {
        return this.salesPersonRepository
                .findById(id)
                .orElseThrow(() -> new SalesPersonException("No sales person found"));
    }

    public void delete(Long id) throws SalesPersonException {
        SalesPerson salesPerson = this.salesPersonRepository
                .findById(id)
                .orElseThrow(() -> new SalesPersonException("No sales person found"));

        this.salesPersonRepository.delete(salesPerson);
    }

    public Long update(SalesPerson salesPerson) throws SalesPersonException {
        SalesPerson salesPersonToUpdate = this.salesPersonRepository
                .findById(salesPerson.getId())
                .orElseThrow(() -> new SalesPersonException("No sales person found"));

        salesPerson.setDealership(salesPerson.getDealership());
        salesPerson.setEmail(salesPerson.getEmail());
        salesPerson.setId(salesPerson.getId());
        salesPerson.setName(salesPerson.getName());
        salesPerson.setPhoneNumber(salesPerson.getPhoneNumber());

        return this.salesPersonRepository.save(salesPersonToUpdate).getId();
    }
}
