package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.Role;
import kpi.ua.exhibition.repository.RoleRepository;
import kpi.ua.exhibition.service.impl.RoleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest {
    @Mock
    private RoleRepository roleRepository;
    @InjectMocks
    private RoleServiceImpl roleService;
    private Role role;

    @Before
    public void setUp() throws Exception {
        role = new Role();
        role.setRoleName(Role.RoleName.USER);
    }

    @Test
    public void getRoleByTitle() {
        when(roleRepository.getRoleByTitle("USER")).thenReturn(role);
        Assert.assertEquals(role, roleService.getRoleByTitle("USER"));
        verify(roleRepository).getRoleByTitle("USER");
    }
}