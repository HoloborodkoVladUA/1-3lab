package kpi.ua.exhibition.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@Table(name = "visitors")
public class Visitor extends Person {
    @ManyToMany
    private List<Exhibition> visitedExhibitions;
    @OneToMany
    private List<Ticket> tickets;
}
