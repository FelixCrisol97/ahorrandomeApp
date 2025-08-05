package com.crisol.ahorrandome.user.domain;

import java.util.UUID;

import com.crisol.ahorrandome.shared.domain.exceptions.InvalidEmailException;
import com.crisol.ahorrandome.shared.domain.exceptions.InvalidPasswordException;
import com.crisol.ahorrandome.shared.domain.security.PasswordEncoder;
import com.crisol.ahorrandome.shared.domain.validation.EmailValidator;
import com.crisol.ahorrandome.shared.domain.validation.PasswordRules;

import java.util.Objects;

public class User {

    private final UUID id;
    private final String email;
    private final String encryptedPassword;

    public User(UUID id, String email, String encryptedPassword) {
        if (!EmailValidator.isValid(email)) {
            throw new InvalidEmailException("Email inválido");
        }
        if (!PasswordRules.isSecure(encryptedPassword)) {
            throw new InvalidPasswordException("Contraseña no cumple reglas mínimas");
        }
        this.id = Objects.requireNonNull(id);
        this.email = email;
        this.encryptedPassword = encryptedPassword;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    
    public boolean matchesPassword(String plainPassword, PasswordEncoder encoder) {
        return encoder.matches(plainPassword, encryptedPassword);
    }
}
