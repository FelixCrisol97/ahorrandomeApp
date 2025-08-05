package com.crisol.ahorrandome.shared.infrastucture.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.crisol.ahorrandome.shared.domain.security.PasswordEncoder;

@Component
public class BcryptPasswordEncoderAdapter implements PasswordEncoder {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String raw) {
        return encoder.encode(raw);
    }

    @Override
    public boolean matches(String raw, String encoded) {
        return encoder.matches(raw, encoded);
    }
}
