package com.apiaularalf2.aula_spring_ralf_2.Services;

import com.apiaularalf2.aula_spring_ralf_2.Models.Messenger;
import com.apiaularalf2.aula_spring_ralf_2.Models.Person;
import com.apiaularalf2.aula_spring_ralf_2.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

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
           return new ResponseEntity<>(messenger, HttpStatus.NOT_FOUND);
       }else
        return new ResponseEntity<>(actionRepository.findById(idFromController), HttpStatus.OK);

    }

    //Metodo para deletar uma pessoa pelo Id
    public ResponseEntity<?> deletePersonById(Long idFromController) {
        if (actionRepository.countById(idFromController) == 0) {
            messenger.setMessenger("Não foi encontrados registros com este código");
            return new ResponseEntity<>(messenger, HttpStatus.NOT_FOUND);
        } else {

            actionRepository.deleteById(idFromController);
            messenger.setMessenger("removido com sucesso");
            return new ResponseEntity<>(messenger, HttpStatus.OK);
        }
    }

    //Metodo para editar dados pegando os dados pelo corpo da requisição
    public ResponseEntity<?> editPerson(Person objFromController){
        if (actionRepository.countById(objFromController.getId())==0){
            messenger.setMessenger("O código informado não existe");
            return new ResponseEntity<>(messenger,HttpStatus.NOT_FOUND);

        }else if (objFromController.getName().equals("")){
            messenger.setMessenger("É necessário informar um nome");
            return new ResponseEntity<>(messenger,HttpStatus.NOT_FOUND);

        } else if (objFromController.getGender().equals("")) {
            messenger.setMessenger("É necessário informar o gênero");
            return new ResponseEntity<>(messenger,HttpStatus.NOT_FOUND);

        }else if (objFromController.getAge()< 0) {
            messenger.setMessenger("É necessário informar idade válida");
            return new ResponseEntity<>(messenger, HttpStatus.NOT_FOUND);

        }else
        return new ResponseEntity<>(actionRepository.save(objFromController),HttpStatus.OK);
    }


}
