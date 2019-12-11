package ru.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idperson;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Transient
    private String confPassword;
    @Column(name="lastname")
    private String lastname;
    @Column(name="age")
    private int age;
    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

    public Person() {}
    public String getConfPassword() {        return confPassword;    }
    public void setConfPassword(String confPassword) {        this.confPassword = confPassword;    }
    public Set<Role> getRoles() {        return roles;    }
    public void setRoles(Set<Role> roles) {        this.roles = roles;    }
    public long getIdperson() {        return idperson;    }
    public void setIdperson(long idperson) {        this.idperson = idperson;    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public String getPassword() {        return password;    }
    public void setPassword(String password) {        this.password = password;    }
    public String getLastname() {        return lastname;    }
    public void setLastname(String lastname) {        this.lastname = lastname; }
    public int getAge() {        return age;    }
    public void setAge(int age) {        this.age = age;    }
}
