package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.Exhibit;

import java.util.List;

public interface ExhibitService {
    Exhibit save(Exhibit exhibit);

    boolean remove(Long exhibitId);


    Exhibit getById(Long id);

    List<Exhibit> getAll();
}
