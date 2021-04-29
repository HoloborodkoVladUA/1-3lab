package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Ticket;
import kpi.ua.exhibition.repository.TicketRepository;
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
public class TicketServiceImplTest {
    @Mock
    private TicketRepository ticketRepository;
    @InjectMocks
    private TicketServiceImpl ticketService;
    private Ticket ticket;

    @Before
    public void setUp() throws Exception {
        ticket = new Ticket();
    }

    @Test
    public void save() {
        when(ticketRepository.save(ticket)).thenReturn(ticket);
        Assert.assertEquals(ticket, ticketService.save(ticket));
        verify(ticketRepository).save(ticket);
    }
}