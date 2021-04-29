package kpi.ua.exhibition.repository;

import kpi.ua.exhibition.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.surname = :surname")
    Author getBySurname(String surname);
}
