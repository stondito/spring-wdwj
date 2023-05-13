package com.example.projectspring.repos;

import com.example.projectspring.models.Car;
import com.example.projectspring.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepositoryI extends JpaRepository<Sale, Long> {

    List<Car> findCarByMake(String make);
}
