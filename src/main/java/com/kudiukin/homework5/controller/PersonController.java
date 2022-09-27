package com.kudiukin.homework5.controller;

import com.kudiukin.homework5.model.Person;
import com.kudiukin.homework5.service.PersonService;
import com.kudiukin.homework5.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@RequestParam Long id) throws NotFoundException {
        return personService.getPersonById(id);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson(@RequestParam Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long deletePerson(@RequestParam Long id) throws NotFoundException {
        personService.deletePerson(id);
        return id;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAll() {
        return personService.getAllPersons();
    }
}