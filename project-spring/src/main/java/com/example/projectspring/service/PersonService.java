package com.example.projectspring.service;

import com.example.projectspring.dao.PersonDAO;
import com.example.projectspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    public int addPerson(Person person) {
        return personDAO.addPerson(person);
    }
}
