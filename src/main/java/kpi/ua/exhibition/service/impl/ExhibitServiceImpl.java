package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Exhibit;
import kpi.ua.exhibition.repository.ExhibitRepository;
import kpi.ua.exhibition.service.ExhibitService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitServiceImpl implements ExhibitService {
    private static final Logger LOGGER = Logger.getLogger(ExhibitServiceImpl.class);
    private final ExhibitRepository exhibitRepository;

    @Autowired
    public ExhibitServiceImpl(ExhibitRepository exhibitRepository) {
        this.exhibitRepository = exhibitRepository;
    }

    @Override
    public Exhibit save(Exhibit exhibit) {
        exhibitRepository.save(exhibit);
        LOGGER.info("The exhibit was created");
        return exhibit;
    }

    @Override
    public boolean remove(Long exhibitId) {
        Exhibit exhibit = exhibitRepository.getOne(exhibitId);
        exhibitRepository.delete(exhibit);
        LOGGER.info("The exhibit was removed");
        return true;
    }

    @Override
    public Exhibit getById(Long id) {
        return exhibitRepository.getOne(id);
    }

    @Override
    public List<Exhibit> getAll() {
        return exhibitRepository.findAll();
    }
}
