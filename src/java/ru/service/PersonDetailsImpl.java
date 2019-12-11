package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.model.Person;
import ru.model.Role;
import ru.repository.PersonRepository;

import java.util.HashSet;
import java.util.Set;


public class PersonDetailsImpl implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    @Transactional(readOnly= true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername( username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for(Role role:person.getRoles())
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        return new org.springframework.security.core.userdetails.User(person.getName(),person.getPassword(), grantedAuthorities);
    }
}
