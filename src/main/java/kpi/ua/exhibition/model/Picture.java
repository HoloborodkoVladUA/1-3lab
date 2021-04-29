package kpi.ua.exhibition.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
@NoArgsConstructor
@AllArgsConstructor
public class Picture extends Exhibit {
    private String title;

    public Picture(Long id, String title) {
        super(id);
        this.title = title;
    }
}
