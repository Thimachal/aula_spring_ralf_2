package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
    @GetMapping("/")
    public String messenger(){
        return "hello";
    }
}
