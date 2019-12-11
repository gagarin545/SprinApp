package ru.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<Person> person;

    public Role() {}

    public long getId() {        return id;    }
    public void setId(long id) {        this.id = id;    }
    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public Set<Person> getPerson() {        return person;    }
    public void setPerson(Set<Person> person) {        this.person = person;    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
