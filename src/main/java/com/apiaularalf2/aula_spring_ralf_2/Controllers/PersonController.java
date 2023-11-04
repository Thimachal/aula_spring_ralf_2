package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import com.apiaularalf2.aula_spring_ralf_2.Models.Person;
import com.apiaularalf2.aula_spring_ralf_2.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonController {

    @Autowired
    private PersonService actionService;

    //Rota para cadastrar pessoas
    @PostMapping("/personsregister")
    public ResponseEntity<?> register(@RequestBody Person personFromFront){

        return actionService.registerPersons(personFromFront);
    }

    //Rota para listas todas as pessoas cadastradas
    @GetMapping("/persons")
    public ResponseEntity<?> list(){
        return actionService.listAllPersons();
    }

    //Rota para selecionar uma pessoa pelo seu id
    @GetMapping("/persons/{idFromUrl}")
    public ResponseEntity<?> listById(@PathVariable Long idFromUrl){
        return actionService.selectPersonById(idFromUrl);

    }

    //Rota para deletar uma pessoa pelo seu id
    @DeleteMapping("/persons/{idFromUrl}")
    public ResponseEntity<?> delete(@PathVariable Long idFromUrl) {

       return actionService.deletePersonById(idFromUrl);
   }
    //Rota para editar dados de uma pessoa pelo corpo da requisição
   @PutMapping("persons/")
    public ResponseEntity<?> update(@RequestBody Person objFromBody ){
        return actionService.editPerson(objFromBody);
   }


}
