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
    private PersonRepository actionService;

    public ResponseEntity<?> register(Person personObj){
        if(personObj.getName().equals("")){
            messenger.setMessenger("O nome precisa ser preenchido");
            return new ResponseEntity<>(messenger, HttpStatus.BAD_REQUEST);
        }else if (personObj.getAge()<0){
            messenger.setMessenger("A idade precisa ser corrigida");
            return new ResponseEntity<>(messenger,HttpStatus.BAD_REQUEST);
        }else
            return new ResponseEntity<>(actionService.save(personObj), HttpStatus.CREATED);
    }

}
