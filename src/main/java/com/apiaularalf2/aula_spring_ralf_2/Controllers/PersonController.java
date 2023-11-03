package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import com.apiaularalf2.aula_spring_ralf_2.Models.Person;
import com.apiaularalf2.aula_spring_ralf_2.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository action;
    @GetMapping("/persons")
    public List<Person> listAllPersons(){
        return action.findAll();
    }

    @GetMapping("/persons/{idFromUrl}")
    public Optional<Person> listById(@PathVariable Long idFromUrl){
        return action.findById(idFromUrl);
    }

    @PostMapping("/personsregister")
    public Person register(@RequestBody Person personFromFront){

        return action.save(personFromFront);
    }
}
