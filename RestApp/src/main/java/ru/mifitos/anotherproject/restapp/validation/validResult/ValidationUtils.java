package ru.mifitos.anotherproject.restapp.validation.validResult;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.mifitos.anotherproject.restapp.validation.handler.personValidation.PersonNotCreatedException;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationUtils {


    public static void handleValidationErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            String errorMsg = errors.stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining("; "));
            throw new PersonNotCreatedException(errorMsg);
        }
    }
}
