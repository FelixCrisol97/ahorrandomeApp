package com.crisol.ahorrandome.shared.domain.exceptions;

    public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String email) {
        super("Invalid email: " + email);
    }
}
