package ru.mifitos.anotherproject.restapp.validation.handler.personValidation;

public class PersonNotCreatedException extends RuntimeException{

    public PersonNotCreatedException(String msg){
        super(msg);
    }


}
