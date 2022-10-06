package com.kudiukin.homework6.service;

import com.kudiukin.homework6.dto.PersonDto;
import com.kudiukin.homework6.utils.exception.NotFoundException;

import java.util.List;

public interface PersonService {

    PersonDto createPerson(PersonDto personDto);

    PersonDto getPersonById(Long id) throws NotFoundException;

    PersonDto updatePerson(PersonDto personDto);

    void deletePerson(Long id) throws NotFoundException;

    List<PersonDto> getAllPersons();
}
