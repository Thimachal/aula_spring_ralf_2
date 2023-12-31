package com.apiaularalf2.aula_spring_ralf_2.Controllers;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import com.apiaularalf2.aula_spring_ralf_2.Services.IMPL.ClientInterface;
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
        try{
            ResponseEntity<?> clientFromService = actionService.registerClientDTO(clientFromFront);
            return new ResponseEntity<>(clientFromService.getBody(),HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/clients")
    public ResponseEntity<?> list(){
        try {
            return new ResponseEntity<>(actionService.listAllClients().getBody(),HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
