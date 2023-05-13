package com.example.projectspring.repos;


import com.example.projectspring.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepositoryI extends JpaRepository<Invoice, Long> {

    Invoice findInvoiceByCustomerName(String name);
}
