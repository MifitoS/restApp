package ru.mifitos.anotherproject.restapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.mifitos.anotherproject.restapp.dto.PersonDTO;
import ru.mifitos.anotherproject.restapp.model.Person;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person personDtoToPerson(PersonDTO person);

    PersonDTO personToDTO(Person person);

}
