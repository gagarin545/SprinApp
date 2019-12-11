package ru.service;

import ru.model.Person;

public interface PersonService {
    void save( Person person);
    Person findByUsername(String username);
}
