package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.repository.PictureRepository;
import kpi.ua.exhibition.service.impl.PictureServiceImpl;
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
public class PictureServiceImplTest {
    @Mock
    private PictureRepository pictureRepository;
    @InjectMocks
    private PictureServiceImpl pictureService;
    private Picture picture;

    @Before
    public void setUp() throws Exception {
        picture = new Picture("picture");
    }

    @Test
    public void save() {
        when(pictureRepository.save(picture)).thenReturn(picture);
        Assert.assertEquals(picture, pictureService.save(picture));
        verify(pictureRepository).save(picture);
    }

    @Test
    public void getByTitle() {
        when(pictureRepository.getByTitle("picture")).thenReturn(picture);
        Assert.assertEquals(picture, pictureService.getByTitle("picture"));
        verify(pictureRepository).getByTitle("picture");
    }
}