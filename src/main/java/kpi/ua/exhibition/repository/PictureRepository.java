package kpi.ua.exhibition.repository;

import kpi.ua.exhibition.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    @Query("select p from Picture p where p.title = :title")
    Picture getByTitle(String title);
}

