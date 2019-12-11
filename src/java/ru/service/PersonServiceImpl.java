package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.model.Person;
import ru.model.Role;
import ru.repository.PersonRepository;
import ru.repository.RoleRepository;
import java.util.HashSet;
import java.util.Set;

public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncodr;
    @Override
    public void save(Person person) {
        person.setPassword(bCryptPasswordEncodr.encode(person.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        person.setRoles(roles);
        personRepository.saveAndFlush( person);
    }

    @Override
    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }
}
