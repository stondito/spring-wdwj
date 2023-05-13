package com.example.projectspring.repos;

import com.example.projectspring.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepositoryI extends JpaRepository<Car, Long> {

    List<Car> findCarByMakeAndModelAndYearAndPrice(String make, String model, int year, BigDecimal price);
}
