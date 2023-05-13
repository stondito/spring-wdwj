package com.example.projectspring.controllers;

import com.example.projectspring.services.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")
@AllArgsConstructor
public class SaleController {

    private SaleService service;


}
