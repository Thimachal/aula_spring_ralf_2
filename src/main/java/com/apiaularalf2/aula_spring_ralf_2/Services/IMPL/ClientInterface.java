package com.apiaularalf2.aula_spring_ralf_2.Services.IMPL;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface ClientInterface {
    public ResponseEntity<?> listAllClients();
    public ResponseEntity<?> registerClientDTO(ClientDTO clientFromFront);
}
