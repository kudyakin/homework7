package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Person;
import com.kudiukin.homework4.utils.exception.NotFoundException;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Long id) throws NotFoundException;

    Person updatePerson(Long Id, Person person);

    Long deletePerson(Long id) throws NotFoundException;

    List<Person> getAllPersons();
}
