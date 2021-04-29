package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.Picture;

public interface PictureService {
    Picture save(Picture picture);

    boolean remove(Long pictureId);

    Picture getByTitle(String title);
}
