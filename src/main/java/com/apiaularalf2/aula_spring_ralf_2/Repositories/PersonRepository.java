package com.apiaularalf2.aula_spring_ralf_2.Repositories;
import com.apiaularalf2.aula_spring_ralf_2.Models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();

    @Override
    Optional<Person> findById(Long idFromService);

    Integer countById(Long idFromService);

    void deleteById(Long idFromService);
}
