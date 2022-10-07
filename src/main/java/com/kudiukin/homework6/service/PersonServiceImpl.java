package com.kudiukin.homework6.service;

import com.kudiukin.homework6.dto.PersonDto;
import com.kudiukin.homework6.repository.PersonRepository;
import com.kudiukin.homework6.NotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.kudiukin.homework6.converter.PersonConverter.getPersonDtoFromPerson;
import static com.kudiukin.homework6.converter.PersonConverter.getPersonFromPersonDto;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        return getPersonDtoFromPerson(personRepository.save(getPersonFromPersonDto(personDto)));
    }

    @Override
    public PersonDto getPersonById(Long id) throws NotFoundException {
        if (personRepository.findById(id).isPresent()) {
            return getPersonDtoFromPerson(personRepository.findById(id).get());
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public void deletePerson(Long id) throws NotFoundException {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        return personRepository.findById(personDto.getId())
                .map(entity -> {
                    entity.setFirstName(personDto.getFirstName());
                    entity.setLastName(personDto.getLastName());
                    entity.setEmail(personDto.getEmail());
                    entity.setPhone(personDto.getPhone());
                    personRepository.save(entity);
                    return getPersonDtoFromPerson(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + personDto.getId()));
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<PersonDto> personDtoList = new ArrayList<>();
        personRepository.findAll().forEach(person -> personDtoList.add(getPersonDtoFromPerson(person)));
        return personDtoList;
    }
}
