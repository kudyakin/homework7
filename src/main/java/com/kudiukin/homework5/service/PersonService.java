package com.kudiukin.homework5.service;

import com.kudiukin.homework5.model.Person;
import com.kudiukin.homework5.utils.exception.NotFoundException;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Long id) throws NotFoundException;

    Person updatePerson(Long Id, Person person);

    Long deletePerson(Long id) throws NotFoundException;

    List<Person> getAllPersons();
}
