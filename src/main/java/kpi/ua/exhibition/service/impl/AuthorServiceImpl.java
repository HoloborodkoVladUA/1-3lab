package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.*;
import kpi.ua.exhibition.repository.AuthorRepository;
import kpi.ua.exhibition.repository.PictureRepository;
import kpi.ua.exhibition.repository.SculptureRepository;
import kpi.ua.exhibition.service.AuthorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final Logger LOGGER = Logger.getLogger(AuthorServiceImpl.class);
    private final AuthorRepository authorRepository;
    private final PictureRepository pictureRepository;
    private final SculptureRepository sculptureRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, PictureRepository pictureRepository,
                             SculptureRepository sculptureRepository) {
        this.authorRepository = authorRepository;
        this.pictureRepository = pictureRepository;
        this.sculptureRepository = sculptureRepository;
    }

    @Override
    public Exhibit createPicture(Long authorId, String title) {
        Author author = authorRepository.getOne(authorId);
        Picture picture = new Picture(title);
        pictureRepository.save(picture);
        author.getPictures().add(picture);
        LOGGER.info("The author created picture");
        return picture;
    }

    @Override
    public Exhibit createSculpture(Long authorId, Material material, String title) {
        Author author = authorRepository.getOne(authorId);
        Sculpture sculpture = new Sculpture(material, title);
        sculptureRepository.save(sculpture);
        author.getSculptures().add(sculpture);
        LOGGER.info("The author created sculpture");
        return sculpture;
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public Author getBySurname(String surname) {
        return authorRepository.getBySurname(surname);
    }

    @Override
    public List<Picture> getPictures(Long authorId) {
        Author author = authorRepository.getOne(authorId);
        return author.getPictures();
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
