package com.kudiukin.homework6.converter;

import com.kudiukin.homework6.dto.PersonDto;
import com.kudiukin.homework6.model.Person;

public final class PersonConverter {

    public static PersonDto getPersonDtoFromPerson (Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setEmail(person.getEmail());
        personDto.setPhone(person.getPhone());
        personDto.setCarts(person.getCarts());
        return personDto;
    }

    public static Person getPersonFromPersonDto (PersonDto personDto) {
        Person person = new Person ();
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setPhone(personDto.getPhone());
        person.setCarts(personDto.getCarts());
        return person;
    }

}
