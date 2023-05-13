package com.example.projectspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class DealershipDto {
    @JsonProperty("dealershipName")
    @NotBlank
    private String name;
}
