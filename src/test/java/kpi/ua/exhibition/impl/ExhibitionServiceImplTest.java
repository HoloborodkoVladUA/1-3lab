package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.repository.ExhibitionRepository;
import kpi.ua.exhibition.service.impl.ExhibitionServiceImpl;
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
public class ExhibitionServiceImplTest {
    @Mock
    private ExhibitionRepository exhibitionRepository;
    @InjectMocks
    private ExhibitionServiceImpl exhibitionService;
    private Exhibition exhibition;
    private Picture picture;
    private Visitor visitor;
    private List<Picture> pictures;
    private List<Visitor> visitors;

    @Before
    public void setUp() throws Exception {
        exhibition = new Exhibition();
        picture  = new Picture("picture");
        visitor = new Visitor();
        pictures = new ArrayList<>();
        visitors = new ArrayList<>();
        pictures.add(picture);
        visitors.add(visitor);
        exhibition.setPictures(pictures);
        exhibition.setVisitors(visitors);
    }

    @Test
    public void addPicture() {
        when(exhibitionRepository.getOne(1L)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionService.addPicture(1L, picture));
        verify(exhibitionRepository).getOne(1L);
    }

    @Test
    public void extractPicture() {
        when(exhibitionRepository.getOne(1L)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionService.extractPicture(1L, picture));
        verify(exhibitionRepository).getOne(1L);
    }

    @Test
    public void letVisitorInto() {
        when(exhibitionRepository.getOne(1L)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionService.letVisitorInto(1L, visitor));
        verify(exhibitionRepository).getOne(1L);
    }

    @Test
    public void letVisitorOut() {
        when(exhibitionRepository.getOne(1L)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionService.letVisitorOut(1L, visitor));
        verify(exhibitionRepository).getOne(1L);
    }

    @Test
    public void getAll() {
        List<Exhibition> exhibitions = new ArrayList<>();
        exhibitions.add(exhibition);
        when(exhibitionRepository.findAll()).thenReturn(exhibitions);
        Assert.assertEquals(exhibitions, exhibitionService.getAll());
        verify(exhibitionRepository).findAll();
    }

    @Test
    public void save() {
        when(exhibitionRepository.save(exhibition)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionService.save(exhibition));
        verify(exhibitionRepository).save(exhibition);
    }

    @Test
    public void getById() {
        when(exhibitionRepository.getOne(1L)).thenReturn(exhibition);
        Assert.assertEquals(exhibition, exhibitionService.getById(1L));
        verify(exhibitionRepository).getOne(1L);
    }
}