package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import com.apiaularalf2.aula_spring_ralf_2.Repositories.ClientRepository;
import com.apiaularalf2.aula_spring_ralf_2.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientService actionService;
    @GetMapping("/client")
    public ResponseEntity<?> list(){
        return actionService.listAllClients();
    }
}
