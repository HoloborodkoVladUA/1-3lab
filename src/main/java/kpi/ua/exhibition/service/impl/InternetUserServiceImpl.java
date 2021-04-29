package kpi.ua.exhibition.service.impl;

import kpi.ua.exhibition.model.InternetUser;
import kpi.ua.exhibition.repository.InternetUserRepository;
import kpi.ua.exhibition.service.InternetUserService;
import org.springframework.stereotype.Service;

@Service
public class InternetUserServiceImpl implements InternetUserService {
    private final InternetUserRepository internetUserRepository;

    public InternetUserServiceImpl(InternetUserRepository internetUserRepository) {
        this.internetUserRepository = internetUserRepository;
    }

    @Override
    public InternetUser getByEmail(String email) {
        return internetUserRepository.getByEmail(email);
    }

    @Override
    public InternetUser save(InternetUser user) {
        return internetUserRepository.save(user);
    }
}
