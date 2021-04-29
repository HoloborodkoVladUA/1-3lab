package kpi.ua.exhibition.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@MappedSuperclass
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles;

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
