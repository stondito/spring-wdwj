package com.example.projectspring.dao;

import com.example.projectspring.model.Person;

import java.util.UUID;

public interface PersonDAO {

    int insertPerson(UUID id, Person person);

    default int addPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

}
