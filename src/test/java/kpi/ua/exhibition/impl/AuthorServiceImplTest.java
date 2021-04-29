package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Author;
import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.model.Sculpture;
import kpi.ua.exhibition.repository.AuthorRepository;
import kpi.ua.exhibition.repository.PictureRepository;
import kpi.ua.exhibition.repository.SculptureRepository;
import kpi.ua.exhibition.service.impl.AuthorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private PictureRepository pictureRepository;
    @Mock
    private SculptureRepository sculptureRepository;
    @InjectMocks
    private AuthorServiceImpl authorService;
    private Author author;
    private Picture picture;
    private Sculpture sculpture;
    private List<Picture> pictures;

    @Before
    public void setUp() throws Exception {
        author = new Author();
        picture = new Picture("picture");
        sculpture = new Sculpture(new Material("clay"), "sculpture");
        pictures = new ArrayList<>();
        pictures.add(picture);
        author.setPictures(pictures);
        List<Sculpture> sculptures = new ArrayList<>();
        sculptures.add(sculpture);
        author.setSculptures(sculptures);
    }

    @Test
    public void createPicture() {
        when(authorRepository.getOne(1L)).thenReturn(author);
        when(pictureRepository.save(picture)).thenReturn(picture);
        Assert.assertEquals(authorService.createPicture(1L, "picture"), picture);
    }

    @Test
    public void createSculpture() {
        when(authorRepository.getOne(1L)).thenReturn(author);
        when(sculptureRepository.save(sculpture)).thenReturn(sculpture);
        Assert.assertEquals(authorService.createSculpture(1L,
                new Material("clay"), "sculture"), sculpture);
    }

    @Test
    public void getById() {
        when(authorRepository.getOne(1L)).thenReturn(author);
        Assert.assertEquals(author,  authorService.getById(1L));
        verify(authorRepository).getOne(1L);
    }

    @Test
    public void getBySurname() {
        String surname = "Shevchenko";
        author.setSurname(surname);
        when(authorRepository.getBySurname(surname)).thenReturn(author);
        Assert.assertEquals(author,  authorService.getBySurname(surname));
        verify(authorRepository).getBySurname(surname);
    }

    @Test
    public void getPictures() {
        when(authorRepository.getOne(1L)).thenReturn(author);
        Assert.assertEquals(pictures,  authorService.getPictures(1L));
        verify(authorRepository).getOne(1L);
    }

    @Test
    public void getAll() {
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        when(authorRepository.findAll()).thenReturn(authors);
        Assert.assertEquals(authors,  authorService.getAll());
        verify(authorRepository).findAll();
    }

    @Test
    public void save() {
        when(authorRepository.save(author)).thenReturn(author);
        Assert.assertEquals(author,  authorService.save(author));
        verify(authorRepository).save(author);
    }
}