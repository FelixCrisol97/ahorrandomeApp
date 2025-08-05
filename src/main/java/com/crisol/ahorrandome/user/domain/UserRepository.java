package com.crisol.ahorrandome.user.domain;

import java.util.UUID;

public interface UserRepository {
    void save(User user);
    boolean existsByEmail(String email);
    User findById(UUID id);
    User findByEmail(String email);
}
