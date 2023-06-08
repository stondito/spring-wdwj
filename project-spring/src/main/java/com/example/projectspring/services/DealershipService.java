package com.example.projectspring.services;

import com.example.projectspring.exceptions.DealershipExceptions;
import com.example.projectspring.models.Dealership;
import com.example.projectspring.repos.DealershipRepositoryI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class DealershipService {

    private final DealershipRepositoryI dealershipRepository;

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

    public Dealership getDealership(Long id) throws DealershipExceptions {
        return this.dealershipRepository
                .findById(id)
                .orElseThrow(() -> DealershipExceptions
                                    .builder()
                                    .message("Dealership not found with id:" + id)
                                    .timeErr(LocalDateTime.now())
                                    .httpStatus(HttpStatus.NOT_FOUND)
                                    .build()
                );
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
