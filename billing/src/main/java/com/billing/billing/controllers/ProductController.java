package com.billing.billing.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProductController {
    
@GetMapping
public String index(){
    return "conectado";
}

}
