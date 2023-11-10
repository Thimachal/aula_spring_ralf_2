package com.apiaularalf2.aula_spring_ralf_2.Services;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import com.apiaularalf2.aula_spring_ralf_2.Repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository actionRepository;

    public ResponseEntity<?> listAllClients() {
        return new ResponseEntity<>(actionRepository.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<?> registerClients(@Valid ClientDTO clientObj) {
        return new ResponseEntity<>(actionRepository.save(clientObj), HttpStatus.OK);
    }
}
