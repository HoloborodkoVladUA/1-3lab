package kpi.ua.exhibition.controller;

import kpi.ua.exhibition.model.InternetUser;
import kpi.ua.exhibition.service.impl.InternetUserServiceImpl;
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
public class InternetUserControllerTest {
    @Mock
    private InternetUserServiceImpl internetUserService;
    @InjectMocks
    private InternetUserController internetUserController;
    private InternetUser user;

    @Before
    public void setUp() throws Exception {
        user = new InternetUser("email", "password");
    }

    @Test
    public void getByEmail() {
        when(internetUserService.getByEmail("email")).thenReturn(user);
        Assert.assertEquals(internetUserController.getByEmail("email"), user);
        verify(internetUserService).getByEmail("email");
    }

    @Test
    public void save() {
        when(internetUserService.save(user)).thenReturn(user);
        Assert.assertEquals(internetUserController.save(user), user);
        verify(internetUserService).save(user);
    }
}