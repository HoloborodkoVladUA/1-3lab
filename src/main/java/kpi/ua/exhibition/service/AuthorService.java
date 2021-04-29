package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.Author;
import kpi.ua.exhibition.model.Exhibit;
import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.model.Picture;

import java.util.List;

public interface AuthorService {
    Exhibit createPicture(Long authorId, String title);

    Exhibit createSculpture(Long authorId, Material material, String title);

    Author getById(Long id);

    Author getBySurname(String surname);

    List<Picture> getPictures(Long authorId);

    List<Author> getAll();

    Author save(Author author);
}
