package com.kudiukin.homework7.repository;

import com.kudiukin.homework7.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findPersonByUsername(String username);
}
