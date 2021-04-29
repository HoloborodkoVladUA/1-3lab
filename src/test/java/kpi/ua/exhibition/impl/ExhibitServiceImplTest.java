package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Exhibit;
import kpi.ua.exhibition.repository.ExhibitRepository;
import kpi.ua.exhibition.service.impl.ExhibitServiceImpl;
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
public class ExhibitServiceImplTest {
    @Mock
    private ExhibitRepository exhibitRepository;
    @InjectMocks
    private ExhibitServiceImpl exhibitService;
    private Exhibit exhibit;

    @Before
    public void setUp() throws Exception {
        exhibit = new Exhibit();
    }

    @Test
    public void save() {
        when(exhibitRepository.save(exhibit)).thenReturn(exhibit);
        Assert.assertEquals(exhibit,  exhibitService.save(exhibit));
        verify(exhibitRepository).save(exhibit);
    }

    @Test
    public void getById() {
        when(exhibitRepository.getOne(1L)).thenReturn(exhibit);
        Assert.assertEquals(exhibit,  exhibitService.getById(1L));
        verify(exhibitRepository).getOne(1L);
    }

    @Test
    public void getAll() {
        List<Exhibit> exhibitList = new ArrayList<>();
        exhibitList.add(exhibit);
        when(exhibitRepository.findAll()).thenReturn(exhibitList);
        Assert.assertEquals(exhibitList,  exhibitService.getAll());
        verify(exhibitRepository).findAll();
    }
}