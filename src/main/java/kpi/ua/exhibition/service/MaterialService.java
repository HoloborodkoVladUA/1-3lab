package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.Material;

public interface MaterialService {
    Material save(Material material);

    boolean remove(Long materialId);
}
