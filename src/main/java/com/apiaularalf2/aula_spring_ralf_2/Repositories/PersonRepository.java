package com.apiaularalf2.aula_spring_ralf_2.Repositories;

import com.apiaularalf2.aula_spring_ralf_2.Models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
