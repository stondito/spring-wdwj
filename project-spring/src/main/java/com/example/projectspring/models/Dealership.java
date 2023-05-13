package com.example.projectspring.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String address;

    private String email;

    @OneToMany(mappedBy = "carDealership")
    private List<Car> car;

    @OneToMany(mappedBy = "dealership")
    private List<SalesPerson> salesPersonList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dealership() {
    }

    public Dealership(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public List<SalesPerson> getSalesPersonList() {
        return salesPersonList;
    }

    public void setSalesPersonList(List<SalesPerson> salesPersonList) {
        this.salesPersonList = salesPersonList;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", car=" + car +
                ", salesPersonList=" + salesPersonList +
                '}';
    }
}

