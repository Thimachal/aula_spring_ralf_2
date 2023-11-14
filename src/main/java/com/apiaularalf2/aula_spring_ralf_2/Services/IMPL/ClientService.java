package com.apiaularalf2.aula_spring_ralf_2.Services.IMPL;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import com.apiaularalf2.aula_spring_ralf_2.Models.Client;
import com.apiaularalf2.aula_spring_ralf_2.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientInterface {
    @Autowired
    private ClientRepository actionRepository;

    public ResponseEntity<?> listAllClients() {
        return new ResponseEntity<>(actionRepository.findAll(), HttpStatus.OK);
    }

/*metodo para salvar
    public ResponseEntity<?> registerClients(@Valid Client clientObj) {
        return new ResponseEntity<>(actionRepository.save(clientObj), HttpStatus.OK);
    }
*/

    //metodo novo da aula 17 TUP
    public ResponseEntity<?> registerClientDTO(ClientDTO clientFromFront) {
        Client client = new Client();

        //opcao para transformar todos os itens de client para DTO
        client.setIdClient(clientFromFront.getIdClientDTO());
        client.setNameClient(clientFromFront.getNameClientDTO());
        client.setEmailClient(clientFromFront.getEmailClientDTO());

        actionRepository.save(client);

        return ResponseEntity.ok(client);
    }
}
