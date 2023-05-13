package com.example.bestcrmintheuniverse.repositories;

import com.example.bestcrmintheuniverse.entities.Client;
import com.example.bestcrmintheuniverse.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAllByClient(Client client);
}
