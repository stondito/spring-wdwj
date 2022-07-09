package com.example.projectspring.api;

import com.example.projectspring.model.Person;
import com.example.projectspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerspn(Person person) {
        personService.addPerson(person);
    }
}
