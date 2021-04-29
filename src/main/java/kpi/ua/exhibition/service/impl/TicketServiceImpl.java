package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Ticket;
import kpi.ua.exhibition.repository.TicketRepository;
import kpi.ua.exhibition.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public boolean remove(Long ticketId) {
        Ticket ticket = ticketRepository.getOne(ticketId);
        ticketRepository.delete(ticket);
        return true;
    }
}
