package com.apiaularalf2.aula_spring_ralf_2.Models;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import com.apiaularalf2.aula_spring_ralf_2.Services.ClientService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @NotEmpty(message = "Informe um nome")
    private String nameClient;
    @Email(message = "Informe um email válido")
    private String emailClient;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }
}
