package ru.mifitos.anotherproject.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mifitos.anotherproject.restapp.model.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {
}
