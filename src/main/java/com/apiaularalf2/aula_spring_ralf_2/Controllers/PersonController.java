package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/person")
    public String messenger(){
        return "hello";
    }
}
