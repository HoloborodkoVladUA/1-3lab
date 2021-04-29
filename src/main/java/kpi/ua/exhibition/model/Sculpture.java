package kpi.ua.exhibition.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "scultures")
@NoArgsConstructor
@AllArgsConstructor
public class Sculpture extends Exhibit {
    @ManyToOne
    private Material material;
    private String title;

    public Sculpture(Long id, Material material, String title) {
        super(id);
        this.material = material;
        this.title = title;
    }
}
