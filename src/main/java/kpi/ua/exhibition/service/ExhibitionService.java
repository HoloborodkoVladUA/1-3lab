package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.*;

import java.util.List;

public interface ExhibitionService {
    Exhibition addPicture(Long exhibitionId, Picture picture);

    Exhibition extractPicture(Long exhibitionId, Picture picture);

    Exhibition letVisitorInto(Long exhibitionId, Visitor visitor);

    Exhibition letVisitorOut(Long exhibitionId, Visitor visitor);

    List<Exhibition> getAll();

    Exhibition save(Exhibition exhibition);

    Exhibition getById(Long id);
}
