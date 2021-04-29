package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.repository.MaterialRepository;
import kpi.ua.exhibition.service.impl.MaterialServiceImpl;
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
public class MaterialServiceImplTest {
    @Mock
    private MaterialRepository materialRepository;
    @InjectMocks
    private MaterialServiceImpl materialService;
    private Material material;

    @Before
    public void setUp() throws Exception {
        material = new Material("clay");
    }

    @Test
    public void save() {
        when(materialRepository.save(material)).thenReturn(material);
        Assert.assertEquals(material, materialService.save(material));
        verify(materialRepository).save(material);
    }
}