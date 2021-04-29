package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.Sculpture;

public interface SculptureService {
    Sculpture save(Sculpture sculpture);

    boolean remove(Long sculptureId);

    Sculpture getByTitle(String title);
}
