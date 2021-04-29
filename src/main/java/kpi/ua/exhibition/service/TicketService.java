package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.Ticket;

public interface TicketService {
    Ticket save(Ticket ticket);

    boolean remove(Long ticketId);
}
