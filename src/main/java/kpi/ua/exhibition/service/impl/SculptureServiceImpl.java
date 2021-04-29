package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Sculpture;
import kpi.ua.exhibition.repository.SculptureRepository;
import kpi.ua.exhibition.service.SculptureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SculptureServiceImpl implements SculptureService {
    private static final Logger LOGGER = Logger.getLogger(SculptureServiceImpl.class);
    private final SculptureRepository sculptureRepository;

    @Autowired
    public SculptureServiceImpl(SculptureRepository sculptureRepository) {
        this.sculptureRepository = sculptureRepository;
    }

    @Override
    public Sculpture save(Sculpture sculpture) {
        sculptureRepository.save(sculpture);
        LOGGER.info("The sculpture was created");
        return sculpture;
    }

    @Override
    public boolean remove(Long sculptureId) {
        Sculpture sculpture = sculptureRepository.getOne(sculptureId);
        sculptureRepository.delete(sculpture);
        LOGGER.info("The sculpture was removed");
        return true;
    }

    @Override
    public Sculpture getByTitle(String title) {
        return sculptureRepository.getByTitle(title);
    }
}
