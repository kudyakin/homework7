package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Person;
import com.kudiukin.homework4.repository.PersonRepository;
import com.kudiukin.homework4.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) throws NotFoundException {
        if (personRepository.findById(id).isPresent()) {
            return personRepository.findById(id).get();
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public Long deletePerson(Long id) throws NotFoundException {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return id;
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        return personRepository.findById(id)
                .map(entity -> {
                    entity.setFirstName(person.getFirstName());
                    entity.setLastName(person.getLastName());
                    entity.setEmail(person.getEmail());
                    entity.setPhone(person.getPhone());
                    return personRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + id));
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }
}
