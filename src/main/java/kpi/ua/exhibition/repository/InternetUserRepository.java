package kpi.ua.exhibition.repository;

import kpi.ua.exhibition.model.InternetUser;
import kpi.ua.exhibition.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetUserRepository extends JpaRepository<Person, Long> {
    @Query("select u from InternetUser u where u.email = :email")
    InternetUser getByEmail(String email);
}
