package kpi.ua.exhibition.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@MappedSuperclass
@Table(name = "exhibits")
public class Exhibit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Author author;
    private String description;

    public Exhibit(Long id) {
        this.id = id;
    }
}
