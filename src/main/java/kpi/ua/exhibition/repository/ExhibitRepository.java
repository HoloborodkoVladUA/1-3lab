package kpi.ua.exhibition.repository;

import kpi.ua.exhibition.model.Exhibit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {
}
