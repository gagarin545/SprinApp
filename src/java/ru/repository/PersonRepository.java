package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
