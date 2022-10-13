package com.kudiukin.homework6.controller;

import com.kudiukin.homework6.dto.PersonDto;
import com.kudiukin.homework6.service.PersonService;
import com.kudiukin.homework6.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "createPerson";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute("person") PersonDto personDto){
        personService.createPerson(personDto);
        return "createPersonSuccess";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getPersonByIdView(Model model) {
        model.addAttribute("personById", new PersonDto());
        return "getPerson";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getPersonById(@ModelAttribute("personById") PersonDto personDto, Model model) throws NotFoundException {
        PersonDto personById = personService.getPersonById(personDto.getId());
        model.addAttribute("personById", personById);
        return "getPersonSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatePersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "updatePerson";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") PersonDto personDto) {
        personService.updatePerson(personDto);
        return "updatePersonSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "deletePerson";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deletePerson(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        personService.deletePerson(personDto.getId());
        return "deletePersonSuccess";
    }

    @GetMapping( "/all")
    public String getAllPersons(Model model) {
        model.addAttribute("all", personService.getAllPersons());
        return "allPersons";
    }
}