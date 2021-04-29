package kpi.ua.exhibition.security;

import kpi.ua.exhibition.exception.AuthenticationException;
import kpi.ua.exhibition.model.InternetUser;
import kpi.ua.exhibition.model.Person;
import kpi.ua.exhibition.model.Role;
import kpi.ua.exhibition.service.InternetUserService;
import kpi.ua.exhibition.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final InternetUserService internetUserService;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(InternetUserService internetUserService,
                                     RoleService roleService) {
        this.internetUserService = internetUserService;
        this.roleService = roleService;
    }

    @Override
    public Person login(String email, String password) throws AuthenticationException {
        Person userFromDb = internetUserService.getByEmail(email);
        if (userFromDb != null && password.equals(userFromDb.getPassword())) {
            return userFromDb;
        }
        throw new AuthenticationException("Wrong login or password");
    }

    @Override
    public Person register(String email, String password) throws AuthenticationException {
        InternetUser newUser = new InternetUser();
        newUser.setEmail(email);
        newUser.setPassword(password);
        Role role = roleService.getRoleByTitle("USER");
        newUser.setRoles(Set.of(role));
        internetUserService.save(newUser);
        return newUser;
    }
}
