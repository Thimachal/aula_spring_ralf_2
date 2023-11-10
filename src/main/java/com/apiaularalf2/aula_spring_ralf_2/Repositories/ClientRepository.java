package com.apiaularalf2.aula_spring_ralf_2.Repositories;

import com.apiaularalf2.aula_spring_ralf_2.DTOs.ClientDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientDTO, Long> {
    List<ClientDTO> findAll();
}
