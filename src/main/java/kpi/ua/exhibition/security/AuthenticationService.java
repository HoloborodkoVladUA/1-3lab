package kpi.ua.exhibition.security;

import kpi.ua.exhibition.exception.AuthenticationException;
import kpi.ua.exhibition.model.Person;

public interface AuthenticationService {
    Person login(String email, String password) throws AuthenticationException;

    Person register(String email, String password) throws AuthenticationException;
}
