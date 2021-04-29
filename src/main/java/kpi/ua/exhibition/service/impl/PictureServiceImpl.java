package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Picture;
import kpi.ua.exhibition.repository.PictureRepository;
import kpi.ua.exhibition.service.PictureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {
    private static final Logger LOGGER = Logger.getLogger(PictureServiceImpl.class);
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture save(Picture picture) {
        pictureRepository.save(picture);
        LOGGER.info("The picture was saved");
        return picture;
    }

    @Override
    public boolean remove(Long pictureId) {
        Picture picture = pictureRepository.getOne(pictureId);
        pictureRepository.delete(picture);
        LOGGER.info("The picture was removed");
        return true;
    }

    @Override
    public Picture getByTitle(String title) {
        return pictureRepository.getByTitle(title);
    }
}
