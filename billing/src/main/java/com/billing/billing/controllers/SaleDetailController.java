package com.billing.billing.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/salesdetail")
public class SaleDetailController {

    @GetMapping
    public String index() {
        return "conectado";
    }

}
