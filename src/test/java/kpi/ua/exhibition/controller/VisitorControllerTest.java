package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.service.impl.VisitorServiceImpl;
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
public class VisitorControllerTest {
    @Mock
    private VisitorServiceImpl visitorService;
    @InjectMocks
    private VisitorController visitorController;
    private Visitor visitor;
    private Visitor visitor1;
    private Exhibition exhibition;

    @Before
    public void setUp() throws Exception {
        visitor = new Visitor();
        visitor1 = new Visitor();
        exhibition = new Exhibition();
    }

    @Test
    public void getAll() {
        List<Visitor> visitors = List.of(visitor, visitor1);
        when(visitorService.getAll()).thenReturn(visitors);
        Assert.assertEquals(visitors, visitorController.getAll());
        verify(visitorService).getAll();
    }

    @Test
    public void add() {
        when(visitorService.save(visitor)).thenReturn(visitor);
        Assert.assertEquals(visitor, visitorController.add(visitor));
        verify(visitorService).save(visitor);
    }

    @Test
    public void visit() {
        when(visitorService.visit(1L,exhibition)).thenReturn(visitor);
        Assert.assertEquals(visitorController.visit(1L, exhibition), visitor);
        verify(visitorService).visit(1L, exhibition);
    }
}