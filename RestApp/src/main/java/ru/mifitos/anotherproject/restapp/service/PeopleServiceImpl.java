package ru.mifitos.anotherproject.restapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mifitos.anotherproject.restapp.dto.PersonDTO;
import ru.mifitos.anotherproject.restapp.mapper.PersonMapper;
import ru.mifitos.anotherproject.restapp.model.Person;
import ru.mifitos.anotherproject.restapp.repository.PeopleRepository;
import ru.mifitos.anotherproject.restapp.validation.handler.personValidation.PersonNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    //Попытаться переделать с проверкой optional.
    @Override
    public PersonDTO findOne(int id) {
        Optional<Person> foundById = peopleRepository.findById(id);
        return foundById.map(PersonMapper.INSTANCE::personToDTO)
                .orElseThrow(PersonNotFoundException::new);
    }


    @Override
    @Transactional
    public void save(PersonDTO person) {

      Person dtoToPerson = PersonMapper.INSTANCE.personDtoToPerson(person);


        enrichPerson(dtoToPerson);
        peopleRepository.save(dtoToPerson);
    }

    private void enrichPerson(Person person) {

        person.setCreateAt(LocalDateTime.now());
        person.setUpdateAt(LocalDateTime.now());
        person.setCreatedWho("ADMIN");

    }
}
