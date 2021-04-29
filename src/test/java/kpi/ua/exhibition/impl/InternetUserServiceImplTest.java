package kpi.ua.exhibition.impl;

import kpi.ua.exhibition.model.InternetUser;
import kpi.ua.exhibition.repository.InternetUserRepository;
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
public class InternetUserServiceImplTest {
    @Mock
    private InternetUserRepository  internetUserRepository;
    @InjectMocks
    private InternetUserServiceImpl internetUserService;
    private InternetUser internetUser;

    @Before
    public void setUp() throws Exception {
        internetUser = new InternetUser("email", "password");
    }

    @Test
    public void getByEmail() {
        when(internetUserRepository.getByEmail("email")).thenReturn(internetUser);
        Assert.assertEquals(internetUser, internetUserService.getByEmail("email"));
        verify(internetUserRepository).getByEmail("email");
    }

    @Test
    public void save() {
        when(internetUserRepository.save(internetUser)).thenReturn(internetUser);
        Assert.assertEquals(internetUser, internetUserService.save(internetUser));
        verify(internetUserRepository).save(internetUser);
    }
}