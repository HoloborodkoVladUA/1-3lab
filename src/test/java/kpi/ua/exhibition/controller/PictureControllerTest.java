package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.service.impl.PictureServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PictureControllerTest {
    @Mock
    private PictureServiceImpl pictureService;
    @InjectMocks
    private PictureController pictureController;
    private Picture picture;

    @Before
    public void setUp() {
        picture = new Picture("picture");
    }

    @Test
    public void save() {
        when(pictureService.save(picture)).thenReturn(picture);
        Assert.assertEquals(picture, pictureController.save(picture));
        verify(pictureService).save(picture);
    }

    @Test
    public void getByTitle() {
        when(pictureService.getByTitle("picture")).thenReturn(picture);
        Assert.assertEquals(picture, pictureController.getByTitle("picture"));
        verify(pictureService).getByTitle("picture");
    }
}