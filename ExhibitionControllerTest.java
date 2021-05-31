package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.service.ExhibitionService;
import kpi.ua.exhibition.service.impl.ExhibitionServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExhibitionControllerTest {
    @Mock
    private ExhibitionServiceImpl exhibitionService;
    @InjectMocks
    private ExhibitionController exhibitionController;
    private Exhibition exhibition;
    private Exhibition exhibition2;
    private Picture picture;
    private Visitor visitor;

    @Before
    public void setUp() throws Exception {
        exhibition = new Exhibition();
        exhibition2 = new Exhibition();
        picture = new Picture("picture");
        visitor = new Visitor();
    }

    @Test
    public void getAll() {
        List<Exhibition> exhibitionList = List.of(exhibition, exhibition2);
        when(exhibitionService.getAll()).thenReturn(exhibitionList);
        Assert.assertEquals(exhibitionList, exhibitionController.getAll());
        verify(exhibitionService).getAll();
    }

    @Test
    public void add() {
        when(exhibitionService.save(exhibition)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionController.add(exhibition));
        verify(exhibitionService).save(exhibition);
    }

    @Test
    public void getById() {
        when(exhibitionService.getById(1L)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionController.getById(1L));
        verify(exhibitionService).getById(1L);
    }

    @Test
    public void addPicture() {
        when(exhibitionService.addPicture(1L, picture)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionController.addPicture(1L, picture));
        verify(exhibitionService).addPicture(1L, picture);
    }

    @Test
    public void extractPicture() {
        when(exhibitionService.extractPicture(1L, picture)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionController.extractPicture(1L, picture));
        verify(exhibitionService).extractPicture(1L, picture);
    }

    @Test
    public void letVisitorInto() {
        when(exhibitionService.letVisitorInto(1L, visitor)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionController.letVisitorInto(1L, visitor));
        verify(exhibitionService).letVisitorInto(1L, visitor);
    }

    @Test
    public void letVisitorOut() {
        when(exhibitionService.letVisitorOut(1L, visitor)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionController.letVisitorOut(1L, visitor));
        verify(exhibitionService).letVisitorOut(1L, visitor);
    }
}