package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import com.apiaularalf2.aula_spring_ralf_2.Services.IMPL.ClientInterface;
import com.apiaularalf2.aula_spring_ralf_2.Services.IMPL.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientInterface actionService;

    @PostMapping("/clientsregister")
    public ResponseEntity<?> register(@Valid @RequestBody ClientDTO clientFromFront){
       ResponseEntity<?> clientFromService = actionService.registerClientDTO(clientFromFront);
        if (clientFromService != null) {
            return new ResponseEntity<>(clientFromService.getBody(),HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/clients")
    public ResponseEntity<?> list(){
        return actionService.listAllClients();
    }
}
