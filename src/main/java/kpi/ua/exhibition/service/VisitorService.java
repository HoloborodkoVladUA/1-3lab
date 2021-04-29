package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Ticket;
import kpi.ua.exhibition.model.Visitor;

import java.util.List;

public interface VisitorService {
    Visitor visit(Long visitorId, Exhibition exhibition);

    Visitor buyTicket(Long visitorId, Ticket ticket);

    List<Visitor> getAll();

    Visitor save(Visitor visitor);
}
