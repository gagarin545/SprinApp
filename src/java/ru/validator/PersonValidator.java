package ru.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import ru.model.Person;
import ru.service.PersonService;

@Component
public class PersonValidator implements Validator {
    @Autowired
    private PersonService personService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "username", "Required");
        if(person.getName().length() < 6 || person.getName().length() >32)
            errors.rejectValue("username", "Size.loginForm.username");
        if(personService.findByUsername(person.getName()) != null)
            errors.rejectValue("username", "Duplicate.userForm.usrname");
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password", "Required");
        if(person.getPassword().length() < 6 || person.getPassword().length() >32)
            errors.rejectValue("password", "Size.userForm.password");
        if(person.getConfPassword().equals(person.getPassword()))
            errors.rejectValue("confPassword", "Different.userForm.password");

    }
}
