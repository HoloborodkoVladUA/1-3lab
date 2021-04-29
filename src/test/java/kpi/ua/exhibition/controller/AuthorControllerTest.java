package kpi.ua.exhibition.controller;


import kpi.ua.exhibition.model.Author;
import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.model.Sculpture;
import kpi.ua.exhibition.service.impl.AuthorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {
    @Mock
    private AuthorServiceImpl authorService;
    @InjectMocks
    private AuthorController authorController;
    private Author author;

    @Before
    public void setUp() {
        author = new Author();
        author.setSurname("Shevchenko");
    }

    @Test
    public void getAll() {
        List<Author> authors = List.of(author);
        when(authorService.getAll()).thenReturn(authors);
        Assert.assertEquals(authors, authorController.getAll());
        verify(authorService).getAll();
    }

    @Test
    public void add() {
        when(authorService.save(author)).thenReturn(author);
        Assert.assertEquals(author, authorController.add(author));
        verify(authorService).save(author);
    }

    @Test
    public void getById() {
        when(authorService.getById(1L)).thenReturn(author);
        Assert.assertEquals(author, authorController.getById(1L));
        verify(authorService).getById(1L);
    }

    @Test
    public void createPicture() {
        Picture picture = new Picture(1L, "Picture");
        when(authorService.createPicture(1L, "Picture")).thenReturn(picture);
        Assert.assertEquals(picture, authorController.createPicture(1L, "Picture"));
        verify(authorService).createPicture(1L, "Picture");
    }

    @Test
    public void createSculpture() {
        Sculpture sculpture = new Sculpture(1L, new Material("clay"), "Sculpture");
        when(authorService.createSculpture(1L, new Material("clay"), "Sculpture"))
                .thenReturn(sculpture);
        Assert.assertEquals(sculpture, authorController.createSculpture(1L,
                new Material("clay"), "Sculpture"));
        verify(authorService).createSculpture(1L, new Material("clay"), "Sculpture");
    }

    @Test
    public void getBySurname() {
        when(authorService.getBySurname("Shevchenko")).thenReturn(author);
        Assert.assertEquals(author, authorController.getBySurname("Shevchenko"));
        verify(authorService).getBySurname("Shevchenko");
    }

}