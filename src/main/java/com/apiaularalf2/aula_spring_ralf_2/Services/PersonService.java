package com.apiaularalf2.aula_spring_ralf_2.Services;

import com.apiaularalf2.aula_spring_ralf_2.Models.Messenger;
import com.apiaularalf2.aula_spring_ralf_2.Models.Person;
import com.apiaularalf2.aula_spring_ralf_2.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class PersonService {
    @Autowired
    private Messenger messenger;

    @Autowired
    private PersonRepository actionRepository;

    //Metodo cadastro de pessoas
    public ResponseEntity<?> registerPersons(Person personObj){
        if(personObj.getName().equals("")){
            messenger.setMessenger("O nome precisa ser preenchido");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
        }else if (personObj.getAge()<0){
            messenger.setMessenger("A idade precisa ser corrigida");
            return new ResponseEntity<>(messenger,HttpStatus.BAD_REQUEST);
        }else
            return new ResponseEntity<>(actionRepository.save(personObj), HttpStatus.CREATED);
    }

    //Metodo para listas pessoas
    public ResponseEntity<?> listAllPersons(){
        return new ResponseEntity<>(actionRepository.findAll(),HttpStatus.OK);
    }


    //Metodo para selecionar/listar uma pessoa pelo seu id
    public ResponseEntity<?> selectPersonById(Long idFromController){
       if(actionRepository.countById(idFromController) == 0){
           messenger.setMessenger("Não foi encontrados registros com este código");
           return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
       }else
        return new ResponseEntity<>(actionRepository.findById(idFromController), HttpStatus.OK);

    }

    public void deletePersonById(Long idFromController){
        actionRepository.deleteById(idFromController), HttpStatus.OK;
    }

    //Metodo para editar dados
    public ResponseEntity<?>


}
