package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Exhibit;
import kpi.ua.exhibition.service.impl.ExhibitServiceImpl;
import org.junit.Assert;
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
public class ExhibitControllerTest {
    @Mock
    private ExhibitServiceImpl exhibitService;
    @InjectMocks
    private ExhibitController exhibitController;

    @Test
    public void getAll() {
        List<Exhibit> exhibits = List.of(new Exhibit());
        when(exhibitService.getAll()).thenReturn(exhibits);
        Assert.assertEquals(exhibitController.getAll(), exhibits);
        verify(exhibitService).getAll();
    }

    @Test
    public void add() {
        Exhibit exhibit = new Exhibit(1L);
        when(exhibitService.save(exhibit)).thenReturn(exhibit);
        Assert.assertEquals(exhibitController.add(exhibit), exhibit);
        verify(exhibitService).save(exhibit);
    }

    @Test
    public void getById() {
        Exhibit exhibit = new Exhibit(1L);
        when(exhibitService.getById(1L)).thenReturn(exhibit);
        Assert.assertEquals(exhibitController.getById(1L), exhibit);
        verify(exhibitService).getById(1L);
    }
}