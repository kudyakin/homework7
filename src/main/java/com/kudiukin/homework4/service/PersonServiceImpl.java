package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Person;
import com.kudiukin.homework4.repository.PersonCollection;
import com.kudiukin.homework4.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonServiceImpl implements PersonService {

    private static Integer personCount = 0;

    private final PersonCollection personCollection;

    public PersonServiceImpl(PersonCollection personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public Person createPerson(Person person) {
        person.setId(++personCount);
        personCollection.getPersons().put(person.getId(), person);
        return person;
    }

    @Override
    public Person getPersonById(Integer id) throws NotFoundException {
        if (personCollection.getPersons().containsKey(id)) {
            return personCollection.getPersons().get(id);
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public void deletePerson(Integer id) throws NotFoundException {
        if (personCollection.getPersons().containsKey(id)) {
            personCollection.getPersons().remove(id);
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public Person updatePerson(Integer id, Person person) throws NotFoundException {
        if (personCollection.getPersons().containsKey(id)) {
            Person tmp = personCollection.getPersons().get(id);
            tmp.setFirstName(person.getFirstName());
            tmp.setLastName(person.getLastName());
            tmp.setEmail(person.getEmail());
            tmp.setPhone(person.getPhone());
            return tmp;
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public Collection<Person> getAllPersons() {
        return personCollection.getPersons().values();
    }
}
