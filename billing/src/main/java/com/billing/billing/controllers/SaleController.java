package com.billing.billing.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.billing.billing.services.SaleService;
import com.billing.billing.requests.*;
import com.billing.billing.responses.SalesResponse;

@RestController
@RequestMapping("/sales")
public class SaleController {
    
    private final SaleService saleService;

  @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }


@GetMapping
public String index(){
    return "conectado";
}

@PostMapping
public ResponseEntity<Object> createSale(@RequestBody SaleRequest saleRequest) {
    try {
        SalesResponse sale = saleService.createSale(saleRequest);
        return ResponseEntity.ok(sale);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error al crear la venta: " + e.getMessage());
    }
} 

}
