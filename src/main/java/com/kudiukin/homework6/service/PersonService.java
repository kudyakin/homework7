package com.kudiukin.homework6.service;

import com.kudiukin.homework6.NotFoundException;
import com.kudiukin.homework6.model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Long id) throws NotFoundException;

    Person updatePerson(Person person);

    void deletePerson(Long id) throws NotFoundException;

    List<Person> getAllPersons();
}
