package com.kudiukin.homework3.service;

import com.kudiukin.homework3.model.Person;
import com.kudiukin.homework3.utils.exception.NotFoundException;

import java.util.Collection;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Integer id) throws NotFoundException;

    Person updatePerson(Integer Id, Person person) throws NotFoundException;

    void deletePerson(Integer id) throws NotFoundException;

    Collection<Person> getAllPersons();
}
