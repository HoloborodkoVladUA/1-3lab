package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Ticket;
import kpi.ua.exhibition.service.impl.TicketServiceImpl;
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
public class TicketControllerTest {
    @Mock
    private TicketServiceImpl ticketService;
    @InjectMocks
    private TicketController ticketController;
    private Ticket ticket;

    @Before
    public void setUp() throws Exception {
        ticket = new Ticket();
    }

    @Test
    public void add() {
        when(ticketService.save(ticket)).thenReturn(ticket);
        Assert.assertEquals(ticket, ticketController.add(ticket));
        verify(ticketService).save(ticket);
    }
}