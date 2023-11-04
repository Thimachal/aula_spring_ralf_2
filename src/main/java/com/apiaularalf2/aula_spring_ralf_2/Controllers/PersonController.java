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

    @PostMapping("/personsregister")
    public Person register(@RequestBody Person personFromFront){

        return action.save(personFromFront);
    }
    @GetMapping("/persons")
    public List<Person> listAllPersons(){
        return action.findAll();
    }

    @GetMapping("/persons/{idFromUrl}")
    public Optional<Person> listPersonsById(@PathVariable Long idFromUrl){
        return action.findById(idFromUrl);

    }

   @DeleteMapping("/persons/{idFromUrl}")
    public void deletPersonById(@PathVariable Long idFromUrl) {

       action.deleteById(idFromUrl);
   }

}
