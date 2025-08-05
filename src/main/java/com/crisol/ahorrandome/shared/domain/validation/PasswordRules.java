package com.crisol.ahorrandome.shared.domain.validation;

public class PasswordRules {

    private static final int MIN_LENGTH = 8;

    public static boolean isSecure(String password) {
        if (password == null) return false;
        return password.length() >= MIN_LENGTH && password.matches(".*[!@#\\$%\\^&\\*].*");
    }
}
