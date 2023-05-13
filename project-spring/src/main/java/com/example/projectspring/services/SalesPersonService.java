package com.example.projectspring.services;

import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.models.SalesPerson;
import com.example.projectspring.repos.SalesPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SalesPersonService {

    private SalesPersonRepository salesPersonRepository;
    private final DealershipService dealershipService;

    public void add(SalesPerson salesPerson, Long id) throws DealershipExceptions {
        Dealership dealership = dealershipService.getDealership(id);

        salesPerson.setDealership(dealership);

        salesPersonRepository.save(salesPerson);
    }
}
