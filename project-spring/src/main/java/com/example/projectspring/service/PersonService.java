package com.example.projectspring.service;

import com.example.projectspring.dao.PersonDAO;
import com.example.projectspring.model.Person;

public class PersonService {
    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    public int addPerson(Person person) {
        return personDAO.addPerson(person);
    }
}
