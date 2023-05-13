package com.example.projectspring.repos;

import com.example.projectspring.models.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealershipRepositoryI extends JpaRepository<Dealership, Long> {
}
