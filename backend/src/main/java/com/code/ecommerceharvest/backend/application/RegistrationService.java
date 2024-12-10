package com.code.ecommerceharvest.backend.application;

import com.code.ecommerceharvest.backend.domain.model.User;
import com.code.ecommerceharvest.backend.domain.port.IUserRepository;

public class RegistrationService {

    private final IUserRepository iUserRepository;

    public RegistrationService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User register (User user){
        return iUserRepository.save(user);
    }
}
