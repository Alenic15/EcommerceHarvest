package com.code.ecommerceharvest.backend.domain.port;

import com.code.ecommerceharvest.backend.domain.model.User;

public interface IUserRepository {
    User save(User user);
    User findByEmail(String email);
    User findById(Integer id);
}
