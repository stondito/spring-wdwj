package com.example.projectspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "make")
    private String make;

    private String model;

    private int year;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "dealership_id", nullable = false)
    private Dealership carDealership;

    private String color;

    private String brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car() {
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", dealership=" + carDealership +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public Dealership getCarDealership() {
        return carDealership;
    }

    public void setCarDealership(Dealership carDealership) {
        this.carDealership = carDealership;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
