package com.example.projectspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CarDto {

    @JsonProperty("dealershipId")
    @NotBlank
    private Long dealershipId;

    @JsonProperty("make")
    @NotBlank
    private String make;

    @JsonProperty("model")
    @NotBlank
    private String model;

    @JsonProperty("year")
    @NotBlank
    private int year;

    @JsonProperty("price")
    @NotBlank
    private BigDecimal price;

    @JsonProperty("color")
    @NotBlank
    private String color;

    @JsonProperty("brand")
    @NotBlank
    private String brand;


}
