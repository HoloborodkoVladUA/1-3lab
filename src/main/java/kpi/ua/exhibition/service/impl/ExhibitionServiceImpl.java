package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Exhibit;
import kpi.ua.exhibition.model.Exhibition;
import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.model.Visitor;
import kpi.ua.exhibition.repository.ExhibitionRepository;
import kpi.ua.exhibition.service.ExhibitionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {
    private static final Logger LOGGER = Logger.getLogger(ExhibitionServiceImpl.class);
    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionServiceImpl(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    @Override
    public Exhibition addPicture(Long exhibitionId, Picture picture) {
        Exhibition exhibition = exhibitionRepository.getOne(exhibitionId);
        exhibition.getPictures().add(picture);
        LOGGER.info("The exhibit was added");
        return exhibition;
    }

    @Override
    public Exhibition extractPicture(Long exhibitionId, Picture picture) {
        Exhibition exhibition = exhibitionRepository.getOne(exhibitionId);
        Iterator<Picture> i = exhibition.getPictures().iterator();
        Exhibit temp;
        while (i.hasNext()) {
            temp = i.next();
            if (temp.equals(picture)) {
                i.remove();
                LOGGER.info("\nThe picture is removed");
                break;
            }
        }
        return exhibition;
    }

    @Override
    public Exhibition letVisitorInto(Long exhibitionId, Visitor visitor) {
        Exhibition exhibition = exhibitionRepository.getOne(exhibitionId);
        exhibition.getVisitors().add(visitor);
        LOGGER.info("The visitor was let in");
        return exhibition;
    }

    @Override
    public Exhibition letVisitorOut(Long exhibitionId, Visitor visitor) {
        Exhibition exhibition = exhibitionRepository.getOne(exhibitionId);
        Iterator<Visitor> i = exhibition.getVisitors().iterator();
        Visitor temp;
        while (i.hasNext()) {
            temp = i.next();
            if (temp.equals(visitor)) {
                i.remove();
                LOGGER.info("\nThe visitor is let out");
                break;
            }
        }
        return exhibition;
    }

    @Override
    public List<Exhibition> getAll() {
        return exhibitionRepository.findAll();
    }

    @Override
    public Exhibition save(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    @Override
    public Exhibition getById(Long id) {
        return exhibitionRepository.getOne(id);
    }
}
