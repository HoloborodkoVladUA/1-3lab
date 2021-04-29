package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.model.Sculpture;
import kpi.ua.exhibition.repository.SculptureRepository;
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
public class SculptureServiceImplTest {
    @Mock
    private SculptureRepository sculptureRepository;
    @InjectMocks
    private SculptureServiceImpl sculptureService;
    private Sculpture sculpture;

    @Before
    public void setUp() throws Exception {
        sculpture = new Sculpture(new Material("clay"), "sculpture");
    }

    @Test
    public void save() {
        when(sculptureRepository.save(sculpture)).thenReturn(sculpture);
        Assert.assertEquals(sculpture, sculptureService.save(sculpture));
        verify(sculptureRepository).save(sculpture);
    }

    @Test
    public void getByTitle() {
        when(sculptureRepository.getByTitle("sculpture")).thenReturn(sculpture);
        Assert.assertEquals(sculpture, sculptureService.getByTitle("sculpture"));
        verify(sculptureRepository).getByTitle("sculpture");
    }
}