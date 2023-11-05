package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import com.apiaularalf2.aula_spring_ralf_2.Models.Client;
import com.apiaularalf2.aula_spring_ralf_2.Services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientService actionService;

    @PostMapping("/clientsregister")
    public ResponseEntity<?> register(@Valid @RequestBody Client clientFromFront){
        return actionService.registerClients(clientFromFront);
    }



    @GetMapping("/clients")
    public ResponseEntity<?> list(){
        return actionService.listAllClients();
    }
}
