package com.crisol.ahorrandome.user.application;

import java.util.UUID;

import com.crisol.ahorrandome.shared.domain.exceptions.EmailAlreadyRegisteredException;
import com.crisol.ahorrandome.shared.domain.security.PasswordEncoder;
import com.crisol.ahorrandome.user.domain.User;
import com.crisol.ahorrandome.user.domain.UserRepository;

public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(String email, String plainPassword) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredException(email);
        }

        UUID id = UUID.randomUUID();
        User user = new User(id, email, passwordEncoder.encode(plainPassword));
        userRepository.save(user);
    }
}
