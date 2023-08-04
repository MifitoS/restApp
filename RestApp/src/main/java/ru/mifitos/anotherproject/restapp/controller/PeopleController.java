package ru.mifitos.anotherproject.restapp.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mifitos.anotherproject.restapp.dto.PersonDTO;
import ru.mifitos.anotherproject.restapp.model.Person;
import ru.mifitos.anotherproject.restapp.service.PeopleService;
import ru.mifitos.anotherproject.restapp.validation.validResult.ValidationUtils;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<Person> getPerson() {
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable int id) {
        return peopleService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonDTO person, BindingResult bindingResult) {
        ValidationUtils.handleValidationErrors(bindingResult);

        peopleService.save(person);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
