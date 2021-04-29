package kpi.ua.exhibition.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class InternetUser extends Person {
    public InternetUser(String email, String password) {
        super(email, password);
    }
}
