package kpi.ua.exhibition.repository;

import kpi.ua.exhibition.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.roleName = :title")
    Role getRoleByTitle(String title);
}
