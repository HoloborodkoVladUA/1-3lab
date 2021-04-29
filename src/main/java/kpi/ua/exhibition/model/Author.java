package kpi.ua.exhibition.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "authors")
public class Author extends Person {
    @OneToMany
    private List<Picture> pictures;
    @OneToMany
    private List<Sculpture> sculptures;
}
