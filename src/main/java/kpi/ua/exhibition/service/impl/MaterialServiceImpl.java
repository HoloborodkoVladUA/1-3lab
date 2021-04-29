package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Material;
import kpi.ua.exhibition.repository.MaterialRepository;
import kpi.ua.exhibition.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material save(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public boolean remove(Long materialId) {
        Material material = materialRepository.getOne(materialId);
        materialRepository.delete(material);
        return true;
    }
}
