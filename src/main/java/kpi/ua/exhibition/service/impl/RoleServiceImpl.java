package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.Role;
import kpi.ua.exhibition.repository.RoleRepository;
import kpi.ua.exhibition.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByTitle(String title) {
        return roleRepository.getRoleByTitle(title);
    }
}
