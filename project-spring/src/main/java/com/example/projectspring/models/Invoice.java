package com.example.projectspring.models;

import jakarta.persistence.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String customerName;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "sales_price")
    private BigDecimal salesPrice;

    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice() {
    }

    public Invoice(String customerName, LocalDate purchaseDate, BigDecimal salesPrice, BigDecimal taxRate) {
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.salesPrice = salesPrice;
        this.taxRate = taxRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal tax = salesPrice.multiply(taxRate);
        return salesPrice.add(tax);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customerName='" + customerName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", salesPrice=" + salesPrice +
                ", taxRate=" + taxRate +
                '}';
    }
}
