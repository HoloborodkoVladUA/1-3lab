package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.model.Sculpture;
import kpi.ua.exhibition.service.impl.SculptureServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SculptureControllerTest {
    @Mock
    private SculptureServiceImpl sculptureService;
    @InjectMocks
    private SculptureController sculptureController;
    private Sculpture sculpture;

    @Before
    public void setUp() {
        sculpture = new Sculpture(new Material("clay"), "sculpture");
    }

    @Test
    public void save() {
        when(sculptureService.save(sculpture)).thenReturn(sculpture);
        Assert.assertEquals(sculpture, sculptureController.save(sculpture));
        verify(sculptureService).save(sculpture);
    }

    @Test
    public void getByTitle() {
        when(sculptureService.getByTitle("sculpture")).thenReturn(sculpture);
        Assert.assertEquals(sculpture, sculptureController.getByTitle("sculpture"));
        verify(sculptureService).getByTitle("sculpture");
    }
}