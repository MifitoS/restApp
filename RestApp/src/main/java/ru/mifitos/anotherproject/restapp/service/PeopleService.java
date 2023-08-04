package ru.mifitos.anotherproject.restapp.service;

import ru.mifitos.anotherproject.restapp.dto.PersonDTO;
import ru.mifitos.anotherproject.restapp.model.Person;

import java.util.List;

public interface PeopleService {

    List<Person> findAll();

    PersonDTO findOne(int id);

    void save(PersonDTO person);
}
