package com.apiaularalf2.aula_spring_ralf_2.DTOs;

import com.apiaularalf2.aula_spring_ralf_2.Models.Client;
import org.springframework.stereotype.Component;


public class ClientDTO {
    private Long idClientDTO;
    private String nameClientDTO;
    private String emailClientDTO;

    //construtor vazia
    public ClientDTO(){

    }
    //construtor principal do DTO, pegando as informações da classe principalClient
    public ClientDTO(Client client) {
        //todos os getters são pegando as propriedades da classe principal e adequando ao DTO
        this.idClientDTO = client.getIdClient();
        this.nameClientDTO = client.getNameClient();
        this.emailClientDTO = client.getEmailClient();
    }

    public Long getIdClientDTO() {
        return idClientDTO;
    }

    public void setIdClientDTO(Long idClientDTO) {
        this.idClientDTO = idClientDTO;
    }

    public String getNameClientDTO() {
        return nameClientDTO;
    }

    public void setNameClientDTO(String nameClientDTO) {
        this.nameClientDTO = nameClientDTO;
    }

    public String getEmailClientDTO() {
        return emailClientDTO;
    }

    public void setEmailClientDTO(String emailClientDTO) {
        this.emailClientDTO = emailClientDTO;
    }
}
