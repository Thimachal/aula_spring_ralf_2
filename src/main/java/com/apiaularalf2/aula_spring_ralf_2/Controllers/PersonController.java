package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import com.apiaularalf2.aula_spring_ralf_2.Models.Person;
import com.apiaularalf2.aula_spring_ralf_2.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository action;
    @GetMapping("/persons")
    public List<Person> listAllPersons(){
        return action.findAll();
    }

    @PostMapping("/personsregister")
    public Person register(@RequestBody Person personFromFront){

        return action.save(personFromFront);
    }
}
