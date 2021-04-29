package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.Ticket;
import kpi.ua.exhibition.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket add(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }
}
