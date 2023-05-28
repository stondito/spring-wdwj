package com.example.projectspring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SaleDto {
    private Date saleDate;

    private double totalPrice;

    private String make;
}
