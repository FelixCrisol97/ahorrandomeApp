package com.crisol.ahorrandome.shared.domain.security;


public interface PasswordEncoder {
    String encode(String raw);
    boolean matches(String raw, String encoded);
}