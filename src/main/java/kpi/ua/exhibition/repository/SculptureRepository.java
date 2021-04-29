package kpi.ua.exhibition.repository;

import kpi.ua.exhibition.model.Sculpture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SculptureRepository extends JpaRepository<Sculpture, Long> {
    @Query("select s from Sculpture s where s.title = :title")
    Sculpture getByTitle(String title);
}
