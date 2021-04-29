package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Ticket;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.repository.VisitorRepository;
import kpi.ua.exhibition.service.impl.VisitorServiceImpl;
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
public class VisitorServiceImplTest {
    @Mock
    private VisitorRepository visitorRepository;
    @InjectMocks
    private VisitorServiceImpl visitorService;
    private Visitor visitor;
    private Visitor visitor2;
    private Ticket ticket;
    private Exhibition exhibition;
    List<Exhibition> exhibitions;
    List<Ticket> tickets;

    @Before
    public void setUp() throws Exception {
        visitor = new Visitor();
        visitor2 = new Visitor();
        exhibition = new Exhibition();
        ticket = new Ticket();
        exhibitions = new ArrayList<>();
        tickets = new ArrayList<>();
        exhibitions.add(exhibition);
        tickets.add(ticket);
        visitor.setVisitedExhibitions(exhibitions);
        visitor.setTickets(tickets);
    }

    @Test
    public void visit() {
        when(visitorRepository.getOne(1L)).thenReturn(visitor);
        Assert.assertEquals(visitor, visitorService.visit(1L, exhibition));
        verify(visitorRepository).getOne(1L);
    }

    @Test
    public void buyTicket() {
        when(visitorRepository.getOne(1L)).thenReturn(visitor);
        Assert.assertEquals(visitor, visitorService.buyTicket(1L, ticket));
        verify(visitorRepository).getOne(1L);
    }

    @Test
    public void getAll() {
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(visitor);
        visitors.add(visitor2);
        when(visitorRepository.findAll()).thenReturn(visitors);
        Assert.assertEquals(visitors, visitorService.getAll());
        verify(visitorRepository).findAll();
    }

    @Test
    public void save() {
        when(visitorRepository.save(visitor)).thenReturn(visitor);
        Assert.assertEquals(visitor, visitorService.save(visitor));
        verify(visitorRepository).save(visitor);
    }
}