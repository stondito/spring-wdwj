package com.example.projectspring.repos;

import com.example.projectspring.models.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {

    SalesPerson findDealershipById(Long id);
}
