package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Ticket;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.repository.VisitorRepository;
import kpi.ua.exhibition.service.VisitorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    private static final Logger LOGGER = Logger.getLogger(VisitorServiceImpl.class);
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor visit(Long visitorId, Exhibition exhibition) {
        Visitor visitor = visitorRepository.getOne(visitorId);
        visitor.getVisitedExhibitions().add(exhibition);
        LOGGER.info("The visitor visited the exhibition");
        return visitor;
    }

    @Override
    public Visitor buyTicket(Long visitorId, Ticket ticket) {
        Visitor visitor = visitorRepository.getOne(visitorId);
        visitor.getTickets().add(ticket);
        LOGGER.info("The visitor bought the ticket");
        return visitor;
    }

    @Override
    public List<Visitor> getAll() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor save(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
}
