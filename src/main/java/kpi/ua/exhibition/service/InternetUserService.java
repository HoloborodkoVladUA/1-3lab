package kpi.ua.exhibition.service;

import kpi.ua.exhibition.model.InternetUser;

public interface InternetUserService {
    InternetUser getByEmail(String email);

    InternetUser save(InternetUser internetUser);
}
